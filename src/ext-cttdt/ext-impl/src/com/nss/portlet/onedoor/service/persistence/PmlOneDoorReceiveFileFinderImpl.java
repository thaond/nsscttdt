package com.nss.portlet.onedoor.service.persistence;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jbpm.graph.exe.ProcessInstance;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.nss.portlet.delegate.model.PmlDelegate;
import com.nss.portlet.delegate.service.persistence.PmlDelegateUtil;
import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.nss.portlet.onedoor.model.impl.PmlOneDoorReceiveFileImpl;
import com.nss.workflowonedoor.OneDoorProcessLiferayWorkflowService;

public class PmlOneDoorReceiveFileFinderImpl extends BasePersistenceImpl implements PmlOneDoorReceiveFileFinder{
	
	/**
	 * Lay so bien nhan cua ho so theo nam
	 * 
	 * @param ddmmyyyyReceiveDate 
	 *             : chuoi dang ngay dd/mm/yyyy
	 * @return so lon nhat trong bang theo nam
	 * @throws SystemException
	 */
	public int getGeneralNumberReceipt(String ddmmyyyyReceiveDate)
			throws SystemException {

		Date receiveDate = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
			receiveDate = format.parse(ddmmyyyyReceiveDate);
		} catch (Exception ex) {			
			return -1;
		}
		
		Session session = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(receiveDate);

			session = openSession();
			StringBuilder query = new StringBuilder();

			query.append("SELECT MAX(generalorderno) AS COUNT_VALUE FROM pml_file , pml_file_pccc ");
			query.append("WHERE ");
			query.append("pml_file_pccc.fileid =  pml_file.fileid ");
			query.append("AND ");
			query.append("date_part('year', pml_file_pccc.inputdatadate) = ");
			query.append(cal.get(Calendar.YEAR));

			
			SQLQuery q = session.createSQLQuery(query.toString());

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	/**
	 * getListFileChuaNhanChuaHoanThanh
	 * pml_processdispose.receivedate IS NULL 
	 * @throws SystemException 
	 */
	public List<PmlOneDoorReceiveFile> getListFileChuaNhanChuaHoanThanh(long userId, List<String> typeList, List<String> valueTypeList, int start, int end,OrderByComparator obc) throws SystemException {
		OneDoorProcessLiferayWorkflowService oneDoorProcessLiferayWorkflowService = new OneDoorProcessLiferayWorkflowService();
		List<ProcessInstance> processInstanceList = oneDoorProcessLiferayWorkflowService.getListProcessInstanceOfActor(userId);
		Session session = null;
		try {
			session = openSession();
			
			String sql = "SELECT DISTINCT pml_file.* ";
			sql += " FROM ";
			sql += " (SELECT  pml_processdispose.fileid , MAX (pml_processdispose.transition_) AS tran ";
			sql += " FROM pml_processdispose ";  
			sql += " WHERE pml_processdispose.processer = " + userId;
			sql += " AND pml_processdispose.receivedate IS NULL ";  
			sql += " GROUP BY pml_processdispose.fileid ";
			sql += " ) AS pml_pro, pml_file , pml_processdispose , pml_wf_onedoor "; 
			sql += " WHERE  pml_pro.fileid = pml_processdispose.fileid "; 
			sql += " AND pml_pro.tran = pml_processdispose.transition_ "; 
			sql += " AND ( pml_pro.fileid = pml_file.fileid ) "; 
			sql += " AND pml_file.exactreturningdate IS NULL ";  
			sql += " AND  pml_wf_onedoor.processid in ( ";
			for (ProcessInstance processInstance : processInstanceList) {
				sql += processInstance.getId() + ",";
			}
			
			sql += "0) ";		
			sql += " AND (pml_file.fileid = pml_wf_onedoor.fileid) "; 
			sql += " AND ( pml_file.filetypeid not in ( ";
			sql += 		" SELECT pml_filetypedelegate.filetypeid FROM pml_filetypedelegate, pml_delegate ";
			sql +=		" WHERE ( pml_filetypedelegate.filetypeid = pml_file.filetypeid AND pml_delegate.assigner =" + userId + ") ";
			sql +=             " AND (pml_filetypedelegate.delegateid = pml_delegate.delegateid) ";
			sql +=					" AND ((pml_delegate.canceldate IS NOT NULL AND pml_delegate.canceldate <= pml_delegate.enddate AND current_timestamp <= pml_delegate.canceldate) ";
			sql +=	                      " OR (pml_delegate.canceldate IS  NULL AND current_timestamp <= pml_delegate.enddate)))) "; 
			
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
					sql = sql.replace( " ) AS pml_pro, pml_file , pml_processdispose , pml_wf_onedoor ", " ) AS pml_pro, pml_file , pml_processdispose , pml_wf_onedoor, pml_file_pccc ");
					sql += "AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {	
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	/**
	 * getListFileCanXuLyTrongNgay
	 */
	
	public List<PmlOneDoorReceiveFile> getListFileCanXuLyTrongNgay(long userId, String toDate, List<String> typeList, List<String> valueTypeList, int start, int end,OrderByComparator obc)throws Exception {
		OneDoorProcessLiferayWorkflowService oneDoorProcessLiferayWorkflowService = new OneDoorProcessLiferayWorkflowService();
		List<ProcessInstance> processInstanceList = oneDoorProcessLiferayWorkflowService.getListProcessInstanceOfActor(userId);
		
		Session session = null;
		try {
			session = openSession();
			String sql = " SELECT DISTINCT pml_file.* ";
			sql += "FROM pml_file , pml_wf_onedoor wfonedoor";	
			sql += " WHERE pml_file.fileid "; 
			sql += " IN ( SELECT pml_processdispose.fileid "; 
			sql += " FROM ( SELECT   pml_processdispose.fileid , MAX (pml_processdispose.transition_) ,  pml_processdispose.expireddate";
			sql += " FROM pml_processdispose, pml_stateprocess "; 
			sql += " WHERE pml_processdispose.processer =" + userId;
			sql += " AND pml_processdispose.dateprocess IS NULL "; 
			sql += " GROUP BY pml_processdispose.fileid ,  pml_processdispose.expireddate ";
			sql += " ) AS pml_processdispose";
			sql += " WHERE pml_processdispose.expireddate >= '"+ toDate + "'";
			sql += " )";  
			sql += " AND pml_file.exactreturningdate IS NULL "; 
			sql += " AND wfonedoor.processid in (";

			for (ProcessInstance processInstance : processInstanceList) {
				sql += processInstance.getId() + ",";
			}
			
			sql += "0) ";		
			sql += " AND (pml_file.fileid = wfonedoor.fileid) "; 
			sql += " AND ( pml_file.filetypeid not in ( ";
			sql += 		" SELECT pml_filetypedelegate.filetypeid FROM pml_filetypedelegate, pml_delegate ";
			sql +=		" WHERE ( pml_filetypedelegate.filetypeid = pml_file.filetypeid AND pml_delegate.assigner =" + userId + ") ";
			sql +=             " AND (pml_filetypedelegate.delegateid = pml_delegate.delegateid) ";
			sql +=					" AND ((pml_delegate.canceldate IS NOT NULL AND pml_delegate.canceldate <= pml_delegate.enddate AND current_timestamp <= pml_delegate.canceldate) ";
			sql +=	                      " OR (pml_delegate.canceldate IS  NULL AND current_timestamp <= pml_delegate.enddate)))) "; 
			
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
//					sql = sql.replace( " FROM pml_file, pml_wf_onedoor ", " FROM pml_file, pml_wf_onedoor, pml_file_pccc");
					sql = sql.replace( "FROM pml_file , pml_wf_onedoor wfonedoor", "FROM pml_file , pml_wf_onedoor wfonedoor, pml_file_pccc");
					sql += "AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {	
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	/**
	 * getListFileQuaHanISOChuaHoanThanh
	 * pml_processdispose.dateprocess > pml_processdispose.expireddate
	 * @throws SystemException 
	 */
	public List<PmlOneDoorReceiveFile> getListFileQuaHanISOChuaHoanThanh(long userId, String toDate, List<String> typeList, List<String> valueTypeList, int start, int end,OrderByComparator obc) throws SystemException {
		OneDoorProcessLiferayWorkflowService oneDoorProcessLiferayWorkflowService = new OneDoorProcessLiferayWorkflowService();
		List<ProcessInstance> processInstanceList = oneDoorProcessLiferayWorkflowService.getListProcessInstanceOfActor(userId);
		Session session = null;
		try {
			session = openSession();
			
			String sql = "SELECT DISTINCT pml_file.* ";
			sql += " FROM "; 
			sql += " ( ";
			sql += " SELECT DISTINCT pml_file.* ";
			sql += " FROM pml_file ";
			sql += " WHERE pml_file.fileid ";
			sql += " IN ( SELECT pml_processdispose.fileid ";
			sql += " FROM ( SELECT   pml_processdispose.fileid , MAX (pml_processdispose.transition_) ";
			sql += " FROM pml_processdispose ";
			sql += " WHERE pml_processdispose.processer = "+userId;
			sql += " AND cast ( pml_processdispose.expireddate as date) < '"+ toDate + "' ";
			sql += " AND pml_processdispose.dateprocess IS NULL ";
			sql += " GROUP BY pml_processdispose.fileid ";
			sql += " ) AS pml_processdispose )  ";
			sql += " AND pml_file.exactreturningdate IS NULL ";
			sql += " ) ";
			sql += "AS pml_file, pml_wf_onedoor";
			
			sql += " WHERE pml_wf_onedoor.processid in ( ";
			
			for (ProcessInstance processInstance : processInstanceList) {
				sql += processInstance.getId() + ",";
			}
			
			sql += "0) ";		
			sql += " AND (pml_file.fileid = pml_wf_onedoor.fileid) "; 
			sql += " AND ( pml_file.filetypeid not in ( ";
			sql += 		" SELECT pml_filetypedelegate.filetypeid FROM pml_filetypedelegate, pml_delegate ";
			sql +=		" WHERE ( pml_filetypedelegate.filetypeid = pml_file.filetypeid AND pml_delegate.assigner =" + userId + ") ";
			sql +=             " AND (pml_filetypedelegate.delegateid = pml_delegate.delegateid) ";
			sql +=					" AND ((pml_delegate.canceldate IS NOT NULL AND pml_delegate.canceldate <= pml_delegate.enddate AND current_timestamp <= pml_delegate.canceldate) ";
			sql +=	                      " OR (pml_delegate.canceldate IS  NULL AND current_timestamp <= pml_delegate.enddate)))) "; 
			
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
					sql = sql.replace( "AS pml_file, pml_wf_onedoor", "AS pml_file, pml_wf_onedoor, pml_file_pccc");
					sql += "AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {	
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	/**
	 * getListFileChoBoSungChuaHoanThanh
	 * pml_stateprocess.stateprocesscode = 'chobosung' 
	 * @throws SystemException 
	 */
	public List<PmlOneDoorReceiveFile> getListFileChoBoSungChuaHoanThanh(long userId, List<String> typeList, List<String> valueTypeList, int start, int end,OrderByComparator obc) throws SystemException {
		OneDoorProcessLiferayWorkflowService oneDoorProcessLiferayWorkflowService = new OneDoorProcessLiferayWorkflowService();
		List<ProcessInstance> processInstanceList = oneDoorProcessLiferayWorkflowService.getListProcessInstanceOfActor(userId);
		Session session = null;
		try {
			session = openSession();
			
			String sql = "SELECT DISTINCT pml_file.* ";
			sql += " FROM "; 
			sql += " ( ";
			sql += " SELECT DISTINCT pml_file.* ";
			sql += " FROM pml_file ";
			sql += " WHERE pml_file.fileid ";
			sql += " IN ( SELECT pml_processdispose.fileid ";
			sql += " FROM ( SELECT   pml_processdispose.fileid , MAX (pml_processdispose.transition_) ";
			sql += " FROM pml_processdispose, pml_stateprocess ";
			sql += " WHERE pml_processdispose.processer = "+userId;
			sql += " AND pml_processdispose.dateprocess IS NULL ";
			sql += " AND pml_stateprocess.stateprocesscode = 'chobosung' ";
			sql += " AND  pml_stateprocess.stateprocessid = pml_processdispose.stateprocessidbefore	";
			sql += " GROUP BY pml_processdispose.fileid ";
			sql += " ) AS pml_processdispose )  ";
			sql += " AND pml_file.exactreturningdate IS NULL ";
			sql += " ) ";
			sql += "AS pml_file, pml_wf_onedoor";
			
			sql += " WHERE pml_wf_onedoor.processid in ( ";
			
			for (ProcessInstance processInstance : processInstanceList) {
				sql += processInstance.getId() + ",";
			}
			
			sql += "0) ";		
			sql += " AND (pml_file.fileid = pml_wf_onedoor.fileid) "; 
			sql += " AND ( pml_file.filetypeid not in ( ";
			sql += 		" SELECT pml_filetypedelegate.filetypeid FROM pml_filetypedelegate, pml_delegate ";
			sql +=		" WHERE ( pml_filetypedelegate.filetypeid = pml_file.filetypeid AND pml_delegate.assigner =" + userId + ") ";
			sql +=             " AND (pml_filetypedelegate.delegateid = pml_delegate.delegateid) ";
			sql +=					" AND ((pml_delegate.canceldate IS NOT NULL AND pml_delegate.canceldate <= pml_delegate.enddate AND current_timestamp <= pml_delegate.canceldate) ";
			sql +=	                      " OR (pml_delegate.canceldate IS  NULL AND current_timestamp <= pml_delegate.enddate)))) "; 
			
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
					sql = sql.replace( "AS pml_file, pml_wf_onedoor", "AS pml_file, pml_wf_onedoor, pml_file_pccc");
					sql += "AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {	
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	/*
	 * get list file of  a concrete user 
	 */
	public List<PmlOneDoorReceiveFile> getListFileNeedProcess(long userId, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		
		OneDoorProcessLiferayWorkflowService oneDoorProcessLiferayWorkflowService = new OneDoorProcessLiferayWorkflowService();
		List<ProcessInstance> processInstanceList = oneDoorProcessLiferayWorkflowService.getListProcessInstanceOfActor(userId);
		Session session = null;
		try {
			session = openSession();
			
			String sql = "SELECT DISTINCT pml_file.* ";
			sql += "FROM pml_file, pml_wf_onedoor";
			
			sql += " WHERE pml_wf_onedoor.processid in ( ";
			
			for (ProcessInstance processInstance : processInstanceList) {
				sql += processInstance.getId() + ",";
			}
			
			sql += "0) ";		
			sql += " AND (pml_file.fileid = pml_wf_onedoor.fileid) "; 
			sql += " AND ( pml_file.filetypeid not in ( ";
			sql += 		" SELECT pml_filetypedelegate.filetypeid FROM pml_filetypedelegate, pml_delegate ";
			sql +=		" WHERE ( pml_filetypedelegate.filetypeid = pml_file.filetypeid AND pml_delegate.assigner =" + userId + ") ";
			sql +=             " AND (pml_filetypedelegate.delegateid = pml_delegate.delegateid) ";
			sql +=					" AND ((pml_delegate.canceldate IS NOT NULL AND pml_delegate.canceldate <= pml_delegate.enddate AND current_timestamp <= pml_delegate.canceldate) ";
			sql +=	                      " OR (pml_delegate.canceldate IS  NULL AND current_timestamp <= pml_delegate.enddate)))) "; 
			
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
					sql = sql.replace( "FROM pml_file, pml_wf_onedoor", "FROM pml_file, pml_wf_onedoor, pml_file_pccc");
					sql += "AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {	
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	public List<PmlOneDoorReceiveFile> getListFileDelegated(long userId, List<String> typeList, List<String> valueTypeList, OrderByComparator obc) throws SystemException {
		
		OneDoorProcessLiferayWorkflowService oneDoorProcessLiferayWorkflowService = new OneDoorProcessLiferayWorkflowService();
		List<ProcessInstance> processInstanceList = oneDoorProcessLiferayWorkflowService.getListProcessInstanceOfActor(userId);
		Session session = null;
		try {
			session = openSession();
			
			String sql = "SELECT DISTINCT pml_file.* ";
			sql += "FROM pml_file, pml_wf_onedoor";
			
			sql += " WHERE pml_wf_onedoor.processid in ( ";
			
			for (ProcessInstance processInstance : processInstanceList) {
				sql += processInstance.getId() + ",";
			}
			
			sql += "0) ";		
			sql += " AND (pml_file.fileid = pml_wf_onedoor.fileid) "; 
			sql += " AND ( pml_file.filetypeid in ( ";
			sql += 		" SELECT pml_filetypedelegate.filetypeid FROM pml_filetypedelegate, pml_delegate ";
			sql +=		" WHERE ( pml_filetypedelegate.filetypeid = pml_file.filetypeid AND pml_delegate.assigner =" + userId + ") ";
			sql +=             " AND (pml_filetypedelegate.delegateid = pml_delegate.delegateid) ";
			sql +=					" AND ((pml_delegate.canceldate IS NOT NULL AND pml_delegate.canceldate <= pml_delegate.enddate AND current_timestamp <= pml_delegate.canceldate) ";
			sql +=	                      " OR (pml_delegate.canceldate IS  NULL AND current_timestamp <= pml_delegate.enddate)))) "; 
			
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
					sql = sql.replace( "FROM pml_file, pml_wf_onedoor", "FROM pml_file, pml_wf_onedoor, pml_file_pccc");
					sql += "AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {					
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	public List<PmlOneDoorReceiveFile> getListFileIsDelegated(long userId, List<String> typeList, List<String> valueTypeList, OrderByComparator obc) throws SystemException {
		List<PmlDelegate> PmlDelegate = new ArrayList<PmlDelegate>();
		try {
			PmlDelegate = PmlDelegateUtil.findByReceiver(userId);
		} catch (Exception e) {
			System.out.println("ERROR: in getListFileIsDelegated :"+ e.getMessage());
		}
		OneDoorProcessLiferayWorkflowService oneDoorProcessLiferayWorkflowService = new OneDoorProcessLiferayWorkflowService();
		List<ProcessInstance> processInstanceList = new ArrayList<ProcessInstance>();
			
		for (PmlDelegate pmlDelegate : PmlDelegate) {
			processInstanceList.addAll(oneDoorProcessLiferayWorkflowService.getListProcessInstanceOfActor(pmlDelegate.getAssigner()));
		}
		
		Session session = null;
		try {
			session = openSession();
			
			String sql = "SELECT DISTINCT pml_file.* ";
			sql += "FROM pml_file, pml_wf_onedoor";
			
			sql += " WHERE pml_wf_onedoor.processid in ( ";
			
			for (ProcessInstance processInstance : processInstanceList) {
				sql += processInstance.getId() + ",";
			}
			
			sql += "0) ";		
			sql += " AND (pml_file.fileid = pml_wf_onedoor.fileid) "; 
			sql += " AND ( pml_file.filetypeid in ( ";
			sql += 		" SELECT pml_filetypedelegate.filetypeid FROM pml_filetypedelegate, pml_delegate ";
			sql +=		" WHERE ( pml_filetypedelegate.filetypeid = pml_file.filetypeid AND pml_delegate.receiver =" + userId + ") ";
			sql +=             " AND (pml_filetypedelegate.delegateid = pml_delegate.delegateid) ";
			sql +=					" AND ((pml_delegate.canceldate IS NOT NULL AND pml_delegate.canceldate <= pml_delegate.enddate AND current_timestamp <= pml_delegate.canceldate) ";
			sql +=	                      " OR (pml_delegate.canceldate IS  NULL AND current_timestamp <= pml_delegate.enddate)))) "; 
			
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
					sql = sql.replace( "FROM pml_file, pml_wf_onedoor", "FROM pml_file, pml_wf_onedoor, pml_file_pccc");
//					sql = sql.replace( " FROM pml_file, pml_wf_onedoor ", " FROM pml_file, pml_wf_onedoor, pml_file_pccc");
					sql += "AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {					
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), -1, -1);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	public List<PmlOneDoorReceiveFile> search(String numberreceipt, String filename, String applicantname,
			String permanentaddress, String telephone, String filetypeid, String tuNgayTiepNhan,
			String denNgayTiepNhan, String tuNgayHenTra, String denNgayHenTra, 
			String tuNgayHSHoanThanh, String denNgayHSHoanThanh, String tuNgayHSTraThuc, String denNgayHSTraThuc, 
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
			boolean flag = false;
			Session session = null;
			try {
				session = openSession();
				
				String sql = "SELECT DISTINCT pml_file.* ";
				sql += " FROM pml_file ";
				
				sql += " WHERE pml_file.fileid = pml_file.fileid ";
				
				if (!"".equals(numberreceipt)) {
					sql += " AND pml_file.numberreceipt LIKE '%" + numberreceipt + "%' ";
				}
				
				if (!"".equals(filename)) {
					sql = sql.replace(" FROM pml_file ", " FROM pml_file,  pml_file_pccc ");
					sql += "AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + filename + "%') ";
					flag = true;
				}
				
				if (!"".equals(applicantname)) {
					sql += " AND pml_file.applicantname LIKE '%" + applicantname + "%' "; 
				}
				
				if (!"".equals(permanentaddress)) {
					sql += " AND pml_file.permanentaddress LIKE '%" + permanentaddress + "%' "; 
				}
				
				if (!"".equals(telephone)) {
					sql += " AND pml_file.telephone LIKE '%" + telephone + "%' ";  
				}
				
				if (!"".equals(filetypeid)) {
					sql += " AND (pml_file.filetypeid = '" + filetypeid + "') ";
				}
				
				if (!"".equals(tuNgayTiepNhan)) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					tuNgayTiepNhan = dateFormatTwo.format(dateFormatOne.parse(tuNgayTiepNhan));
					if (flag) {
						sql += " AND (pml_file.inputdatadate >= '" + tuNgayTiepNhan + "') ";
					} else {
						sql = sql.replace(" FROM pml_file ", " FROM pml_file,  pml_file_pccc ");
						sql += " AND (pml_file.inputdatadate >= '" + tuNgayTiepNhan + "') ";
						flag = true;
					}
				}
				
				if (!"".equals(denNgayTiepNhan)) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					denNgayTiepNhan = dateFormatTwo.format(dateFormatOne.parse(denNgayTiepNhan));
					if (flag) {
						sql += " AND (pml_file.inputdatadate <= '" + denNgayTiepNhan + "') ";
					} else {
						sql = sql.replace(" FROM pml_file ", " FROM pml_file,  pml_file_pccc ");
						sql += " AND (pml_file.inputdatadate <= '" + denNgayTiepNhan + "') ";
						flag = true;
					}
				}
				
				if (!"".equals(tuNgayHenTra)) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					tuNgayHenTra = dateFormatTwo.format(dateFormatOne.parse(tuNgayHenTra));
					sql += " AND (pml_file.expectedreturningdate >= '" + tuNgayHenTra + "') ";
				}
				if (!"".equals(denNgayHenTra)) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					denNgayHenTra = dateFormatTwo.format(dateFormatOne.parse(denNgayHenTra));
					sql += " AND (pml_file.expectedreturningdate <= '" + denNgayHenTra + "') ";
				}
				
				if (!"".equals(tuNgayHSHoanThanh)) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					tuNgayHSHoanThanh = dateFormatTwo.format(dateFormatOne.parse(tuNgayHSHoanThanh));
					sql += " AND (pml_file.exactreturningdate >= '" + tuNgayHSHoanThanh + "') ";
				}
				
				if (!"".equals(denNgayHSHoanThanh)) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					denNgayHSHoanThanh = dateFormatTwo.format(dateFormatOne.parse(denNgayHSHoanThanh));
					sql += " AND (pml_file.exactreturningdate <= '" + denNgayHSHoanThanh + "') ";
				}
				if (!"".equals(tuNgayHSTraThuc)) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					tuNgayHSTraThuc = dateFormatTwo.format(dateFormatOne.parse(tuNgayHSTraThuc));
					sql += " AND (pml_file.exactreturningdate >= '" + tuNgayHSTraThuc + "') ";
				}
				
				if (!"".equals(denNgayHSTraThuc)) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					denNgayHSTraThuc = dateFormatTwo.format(dateFormatOne.parse(denNgayHSTraThuc));
					sql += " AND (pml_file.exactreturningdate <= '" + denNgayHSTraThuc + "') ";
				}			
				
				
				if (typeList.size() > 0) { 
					if ("mahoso".equals(typeList.get(0))) {
						sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(0))) {
						if (flag) {
							sql += " AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
						}
						else {
							sql = sql.replace( " FROM pml_file ", " FROM pml_file, pml_file_pccc ");
							sql += " AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
						}
						
					} else if ("loaihoso".equals(typeList.get(0))) {
						sql += " AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(0))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(0))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(0))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(0))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(0))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
							sql += " AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					
				}
				if (typeList.size() > 1) {
					for (int i = 1; i < typeList.size(); i++) {	
						String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
						if ("mahoso".equals(typeList.get(i))) {
							sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
							
						} else if ("tenhoso".equals(typeList.get(i))) {						
							sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
							sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
							
						} else if ("loaihoso".equals(typeList.get(i))) {
							sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
							
						} else if ("ngaygui".equals(typeList.get(i))) {
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
							//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
							//TODO
						} else if ("ngaynhan".equals(typeList.get(i))) {
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
							//TODO
						} else if ("ngayhethan".equals(typeList.get(i))) {
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
							//TODO
						} else if ("ngayhentrakhach".equals(typeList.get(i))) {
							SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
							SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
							if (!"".equals(valueTypeList.get(i))) {
								String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
								String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
								sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
							}
						}
						sql = sqlHelp;
					}
				}
				sql = CustomSQLUtil.replaceOrderBy(sql, obc);
				SQLQuery q = session.createSQLQuery(sql);
				q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
				
				return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), start, end);
			} catch (Exception e) {
				throw new SystemException(e);
			}
			finally{
				closeSession(session);
			}
		}
	/**
	 * lay ds file da tra
	 * @param fileTypeIds
	 * @param year
	 * @param typeList
	 * @param valueTypeList
	 * @param start
	 * @param end
	 * @param obc
	 * @return
	 * @throws SystemException
	 */
	public List<PmlOneDoorReceiveFile> findByPMLFILERETURN (List<String> fileTypeIds, int year, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		
		String dateString = year + "-01-01";
		Session session = null;
		try {
			String fileTypeIdStrings ="";
			if (fileTypeIds.size() != 0) {
				for (int i = 0; i < fileTypeIds.size() ; i++) {
					fileTypeIdStrings += "'" + fileTypeIds.get(i) + "'";
					if (i < fileTypeIds.size() - 1) {
						fileTypeIdStrings += ","; 
					}
				}
			} else {
				fileTypeIdStrings = " 0 ";
			}
			
			session = openSession();
			String sql = "SELECT DISTINCT (pml_file.*) ";
			sql += " FROM pml_file, pml_file_pccc "; 
			sql += " WHERE ";
			sql += " pml_file.filetypeid IN ( "+ fileTypeIdStrings +" )";
			sql += " AND (pml_file.fileid = pml_file_pccc.fileid ) ";
			sql += " AND (pml_file.exactreturningdate IS NOT NULL AND pml_file.exactreturningdate >= '"+ dateString +"') ";
			 
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
					sql += " AND ( pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {	
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}

			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			 
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	/**
	 * for portlet onedoorfileprocessed
	 */
	
	public List<PmlOneDoorReceiveFile> findByTEN_MA_NAM_HS(long userId, int year, List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		String beginAppDate = year + "-01-01";
		String endAppDate = year + "-12-31";
		
		Session session = null;
		try {
			session = openSession();
			
			String sql = " SELECT DISTINCT (pml_file.*) "; 
			sql += "FROM pml_file, pml_file_pccc, ( ";
			sql += 				" SELECT   pml_processdispose.fileid , MAX (pml_processdispose.transition_) "; 
			sql +=				" FROM pml_processdispose ";
			sql +=				" WHERE pml_processdispose.processer = " + userId;  
			sql +=				" AND pml_processdispose.dateprocess IS NOT NULL "; 
			sql +=				" GROUP BY pml_processdispose.fileid  )  pml_processdispose ";
			sql += " WHERE (pml_file_pccc.fileid = pml_file.fileid ) "; 
			sql += " AND(pml_file.fileid = pml_processdispose.fileid) ";
			sql += " AND (pml_file.applicationdate >= '" + beginAppDate + "') ";
			sql += " AND (pml_file.applicationdate <= '" + endAppDate + "' ) ";
			
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
					sql += " AND ( pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {	
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}
			
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	} 
	
	/**
	 *  BAO CAO HO SO THANG -- YEN --- 13/05/2010
	 */
	// TON DAU KY - BC THANG
	public List<PmlOneDoorReceiveFile> getSoLuongHSTonBCThang(List<PmlFileType> fileTypeList, String fromDate, List<String> typeList,
			List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		try {
			session = openSession();

			String sql = " SELECT  DISTINCT pml_file.* ";
			sql += " FROM ( ";
			sql += 		"  SELECT pml_processdispose.fileid , MAX(pml_processdispose.transition_ ) as tran ";
			sql += 		"  FROM pml_processdispose ";
			sql += 		" WHERE pml_processdispose.fileid IN (";
			sql += 			 " SELECT DISTINCT pml_file.fileid ";
			sql +=			 " FROM pml_file , pml_filetype ";
			sql +=			 " WHERE pml_filetype.filetypeid IN (";
			
			for(PmlFileType fileType : fileTypeList) {
				sql += "'" + fileType.getFileTypeId() + "',";
			}
			sql +=			 " '0')";
			sql += 			 " AND pml_filetype.filetypeid = pml_file.filetypeid ";
			sql +=		 " ) ";
			sql += 		"  GROUP BY pml_processdispose.fileid ";
			sql += ") AS pml_pro, pml_file, pml_processdispose ";
			sql += " WHERE  pml_pro.fileid = pml_processdispose.fileid ";
			sql += " AND pml_pro.tran = pml_processdispose.transition_  ";
			sql += " AND ( pml_pro.fileid = pml_file.fileid ) ";
			sql += " AND ( pml_processdispose.senddate IS NOT NULL AND pml_processdispose.senddate < '" + fromDate + "') ";
			sql += " AND ( pml_processdispose.dateprocess IS NULL OR pml_processdispose.dateprocess >= '" + fromDate + "') ";
			//sql += " AND ( pml_file.exactreturningdate IS NULL OR pml_file.exactreturningdate >= '" + fromDate + "') ";
			
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
					sql = sql.replace( ") AS pml_pro, pml_file, pml_processdispose ", ") AS pml_pro, pml_file, pml_processdispose, pml_file_pccc");
					sql += "AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {	
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	//HS NHAN TRONG THANG - BC THANG 
	public List<PmlOneDoorReceiveFile> getSoLuongHSNhanTrongThang(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String sql = " SELECT  DISTINCT pml_file.* ";
			sql += " FROM ( ";
			sql += 		"  SELECT pml_processdispose.fileid , MAX(pml_processdispose.transition_ ) as tran ";
			sql += 		"  FROM pml_processdispose ";
			sql += 		" WHERE pml_processdispose.fileid IN (";
			sql += 			 " SELECT DISTINCT pml_file.fileid ";
			sql +=			 " FROM pml_file , pml_filetype ";
			sql +=			 " WHERE pml_filetype.filetypeid IN (";
			
			for(PmlFileType fileType : fileTypeList) {
				sql += "'" + fileType.getFileTypeId() + "',";
			}
			sql +=			 " '0')";
			sql += 			 " AND pml_filetype.filetypeid = pml_file.filetypeid ";
			sql +=		 " ) ";
			sql += 		"  GROUP BY pml_processdispose.fileid ";
			sql += ") AS pml_pro, pml_file, pml_processdispose ";
			sql += " WHERE  pml_pro.fileid = pml_processdispose.fileid ";
			sql += " AND pml_pro.tran = pml_processdispose.transition_  ";
			sql += " AND ( pml_pro.fileid = pml_file.fileid ) ";
			sql += " AND pml_processdispose.senddate IS NOT NULL ";
			sql += " AND ( '" + fromDate + "' <= pml_processdispose.senddate AND pml_processdispose.senddate <= '" + toDate + "') ";
			
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
					sql = sql.replace( ") AS pml_pro, pml_file, pml_processdispose ", ") AS pml_pro, pml_file , pml_processdispose, pml_file_pccc");
					sql += "AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {	
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	// TONG = TON DAU KY + HS NHAN TRONG THANG
	public List<PmlOneDoorReceiveFile> getSoLuongTongHS(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String sql = " SELECT  DISTINCT pml_file.* ";
			sql += " FROM ( ";
			sql += 		"  SELECT pml_processdispose.fileid , MAX(pml_processdispose.transition_ ) as tran ";
			sql += 		"  FROM pml_processdispose ";
			sql += 		" WHERE pml_processdispose.fileid IN (";
			sql += 			 " SELECT DISTINCT pml_file.fileid ";
			sql +=			 " FROM pml_file , pml_filetype ";
			sql +=			 " WHERE pml_filetype.filetypeid IN (";
			
			for(PmlFileType fileType : fileTypeList) {
				sql += "'" + fileType.getFileTypeId() + "',";
			}
			sql +=			 " '0')";
			sql += 			 " AND pml_filetype.filetypeid = pml_file.filetypeid ";
			sql +=		 " ) ";
			sql += 		" GROUP BY pml_processdispose.fileid ";
			sql += ") AS pml_pro, pml_file, pml_processdispose ";
			sql += " WHERE  pml_pro.fileid = pml_processdispose.fileid ";
			sql += " AND pml_pro.tran = pml_processdispose.transition_  ";
			sql += " AND ( pml_pro.fileid = pml_file.fileid ) ";
			sql += " AND pml_processdispose.senddate IS NOT NULL ";
			sql += " AND ( ";
			sql += 			" ( pml_processdispose.senddate < '" + fromDate + "' ";
			sql += 				" AND ( pml_processdispose.dateprocess IS NULL OR pml_processdispose.dateprocess >= '" + fromDate + "') ";
			sql += 			"  ) ";
			sql += 			" OR ( '" + fromDate + "' <= pml_processdispose.senddate AND pml_processdispose.senddate <= '" + toDate + "' ) "; 
			sql += " ) ";
			//sql += " AND ( pml_file.exactreturningdate IS NULL OR pml_file.exactreturningdate >= '" + fromDate + "') ";
			
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
					sql = sql.replace( ") AS pml_pro, pml_file, pml_processdispose ", ") AS pml_pro, pml_file , pml_processdispose, pml_file_pccc");
					sql += "AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {	
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	// SO DUNG HAN -- BC THANG
	public List<PmlOneDoorReceiveFile> getSoHSHoanThanhDungHan(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String sql = " SELECT  DISTINCT pml_file.* ";
			sql += " FROM ( ";
			sql += 		"  SELECT pml_processdispose.fileid , MAX(pml_processdispose.transition_ ) as tran ";
			sql += 		"  FROM pml_processdispose ";
			sql += 		" WHERE pml_processdispose.fileid IN (";
			sql += 			 " SELECT DISTINCT pml_file.fileid ";
			sql +=			 " FROM pml_file , pml_filetype ";
			sql +=			 " WHERE pml_filetype.filetypeid IN (";
			
			for(PmlFileType fileType : fileTypeList) {
				sql += "'" + fileType.getFileTypeId() + "',";
			}
			sql +=			 " '0')";	
			sql += 			 " AND pml_filetype.filetypeid = pml_file.filetypeid ";
			sql +=		 " ) ";
			sql += 		"  GROUP BY pml_processdispose.fileid ";
			sql += ") AS pml_pro, pml_file, pml_processdispose ";
			sql += " WHERE  pml_pro.fileid = pml_processdispose.fileid ";
			sql += " AND pml_pro.tran = pml_processdispose.transition_  ";
			sql += " AND ( pml_pro.fileid = pml_file.fileid ) ";
			sql += " AND  pml_processdispose.dateprocess IS NOT NULL ";
			sql += " AND pml_processdispose.expireddate IS NOT NULL ";
			sql += " AND  pml_file.exactreturningdate IS NOT NULL ";
			sql += " AND ('" + fromDate + "' <= pml_processdispose.dateprocess AND pml_processdispose.dateprocess <= '" + toDate + "' ) ";
			sql += " AND ( pml_file.exactreturningdate <= pml_processdispose.expireddate) ";
			
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
					sql = sql.replace( ") AS pml_pro, pml_file , pml_processdispose ", ") AS pml_pro, pml_file , pml_processdispose, pml_file_pccc");
					sql += "AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {	
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	// SO HS HOAN THANH TRE HAN -- BC THANG
	public List<PmlOneDoorReceiveFile> getSoHSHoanThanhTreHan(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String sql = " SELECT  DISTINCT pml_file.* ";
			sql += " FROM ( ";
			sql += 		"  SELECT pml_processdispose.fileid , MAX(pml_processdispose.transition_ ) as tran ";
			sql += 		"  FROM pml_processdispose ";
			sql += 		" WHERE pml_processdispose.fileid IN (";
			sql += 			 " SELECT DISTINCT pml_file.fileid ";
			sql +=			 " FROM pml_file , pml_filetype ";
			sql +=			 " WHERE pml_filetype.filetypeid IN (";
			
			for(PmlFileType fileType : fileTypeList) {
				sql += "'" + fileType.getFileTypeId() + "',";
			}
			sql +=			 " '0')";
			sql += 			 " AND pml_filetype.filetypeid = pml_file.filetypeid ";
			sql +=		 " ) ";
			sql += 		"  GROUP BY pml_processdispose.fileid ";
			sql += ") AS pml_pro, pml_file, pml_processdispose ";
			sql += " WHERE  pml_pro.fileid = pml_processdispose.fileid ";
			sql += " AND pml_pro.tran = pml_processdispose.transition_  ";
			sql += " AND ( pml_pro.fileid = pml_file.fileid ) ";
			sql += " AND  pml_processdispose.dateprocess IS NOT NULL ";
			sql += " AND pml_processdispose.expireddate IS NOT NULL ";
			sql += " AND  pml_file.exactreturningdate IS NOT NULL ";
			sql += " AND ('" + fromDate + "' <= pml_processdispose.dateprocess AND pml_processdispose.dateprocess <= '" + toDate + "' ) ";
			sql += " AND ( pml_file.exactreturningdate > pml_processdispose.expireddate) ";
			
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
					sql = sql.replace( ") AS pml_pro, pml_file , pml_processdispose ", ") AS pml_pro, pml_file , pml_processdispose, pml_file_pccc");
					sql += "AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {	
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	// SO HS DANG THU LY DUNG HAN -- BC THANG
	public List<PmlOneDoorReceiveFile> getSoHSDangThuLyDungHan(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			
			String sql = " SELECT  DISTINCT pml_file.* ";
			sql += " FROM ( ";
			sql += 		"  SELECT pml_processdispose.fileid , MAX(pml_processdispose.transition_ ) as tran ";
			sql += 		"  FROM pml_processdispose ";
			sql += 		" WHERE pml_processdispose.fileid IN (";
			sql += 			 " SELECT DISTINCT pml_file.fileid ";
			sql +=			 " FROM pml_file , pml_filetype ";
			sql +=			 " WHERE pml_filetype.filetypeid IN (";
			
			for(PmlFileType fileType : fileTypeList) {
				sql += "'" + fileType.getFileTypeId() + "',";
			}
			sql +=			 " '0')";
			sql += 			 " AND pml_filetype.filetypeid = pml_file.filetypeid ";
			sql +=		 " ) ";
			sql += 		"  GROUP BY pml_processdispose.fileid ";
			sql += ") AS pml_pro, pml_file, pml_processdispose, pml_stateprocess ";
			sql += " WHERE  pml_pro.fileid = pml_processdispose.fileid ";
			sql += " AND pml_pro.tran = pml_processdispose.transition_  ";
			sql += " AND ( pml_pro.fileid = pml_file.fileid ) ";
			sql += " AND ( pml_stateprocess.stateprocessid = pml_processdispose.stateprocessidbefore )"; 
			sql += " AND ( pml_processdispose.dateprocess IS NULL OR pml_processdispose.dateprocess > '" + toDate + "') ";
			sql += " AND ( pml_processdispose.expireddate IS NOT NULL AND '" + toDate + "' <= pml_processdispose.expireddate ) ";
			sql += " AND ( pml_processdispose.senddate IS NOT NULL ) ";
			sql += " AND ( ";
			sql += 			" (  pml_stateprocess.stateprocesscode != 'chobosung' AND pml_processdispose.senddate <= '" + toDate + "' )"; 
			sql += 			" OR ( pml_stateprocess.stateprocesscode = 'chobosung' ";
			sql += 			" AND (pml_processdispose.senddate < '" + fromDate + "' OR pml_processdispose.senddate > '" + toDate + "' ) ";
			sql += " )) "; 
			//sql += " AND ( pml_file.exactreturningdate IS NULL ) ";
			
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
					sql = sql.replace( ") AS pml_pro, pml_file, pml_processdispose, pml_stateprocess ", ") AS pml_pro, pml_file, pml_processdispose, pml_stateprocess , pml_file_pccc");
					sql += "AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {	
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	// SO HS DANG THU LY TRE HAN -- BC THANG
	public List<PmlOneDoorReceiveFile> getSoHSDangThuLyTreHan(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String sql = " SELECT  DISTINCT pml_file.* ";
			sql += " FROM ( ";
			sql += 		"  SELECT pml_processdispose.fileid , MAX(pml_processdispose.transition_ ) as tran ";
			sql += 		"  FROM pml_processdispose ";
			sql += 		" WHERE pml_processdispose.fileid IN (";
			sql += 			 " SELECT DISTINCT pml_file.fileid ";
			sql +=			 " FROM pml_file , pml_filetype ";
			sql +=			 " WHERE pml_filetype.filetypeid IN (";
			
			for(PmlFileType fileType : fileTypeList) {
				sql += "'" + fileType.getFileTypeId() + "',";
			}
			sql +=			 " '0')";
			sql += 			 " AND pml_filetype.filetypeid = pml_file.filetypeid ";
			sql +=		 " ) ";
			sql += 		"  GROUP BY pml_processdispose.fileid ";
			sql += ") AS pml_pro, pml_file, pml_processdispose, pml_stateprocess ";
			sql += " WHERE  pml_pro.fileid = pml_processdispose.fileid ";
			sql += " AND pml_pro.tran = pml_processdispose.transition_  ";
			sql += " AND ( pml_pro.fileid = pml_file.fileid ) ";
			sql += " AND ( pml_stateprocess.stateprocessid = pml_processdispose.stateprocessidbefore ) ";
			sql += " AND ( pml_processdispose.dateprocess IS NULL OR pml_processdispose.dateprocess > '" + toDate + "') ";
			sql += " AND ( pml_processdispose.expireddate IS NOT NULL AND '" + toDate + "' > pml_processdispose.expireddate ) ";
			sql += " AND ( pml_processdispose.senddate IS NOT NULL ) ";
			sql += " AND ( ";
			sql += 			" (  pml_stateprocess.stateprocesscode != 'chobosung' AND pml_processdispose.senddate <= '" + toDate + "' )"; 
			sql += 			" OR ( pml_stateprocess.stateprocesscode = 'chobosung' ";
			sql += 			" AND (pml_processdispose.senddate < '" + fromDate + "' OR pml_processdispose.senddate > '" + toDate + "' ) ";
			sql += " )) "; 
			//sql += " AND ( pml_file.exactreturningdate IS NULL ) ";		
					
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
					sql = sql.replace( ") AS pml_pro, pml_file, pml_processdispose, pml_stateprocess ", ") AS pml_pro, pml_file, pml_processdispose, pml_stateprocess, pml_file_pccc");
					sql += "AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {	
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	// SO HS CHO BO SUNG -- BC THANG
	public List<PmlOneDoorReceiveFile> getSoHSChoBoSung(List<PmlFileType> fileTypeList, String fromDate, String toDate,
			List<String> typeList, List<String> valueTypeList, int start, int end, OrderByComparator obc) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			
			String sql = " SELECT  DISTINCT pml_file.* ";
			sql += " FROM ( ";
			sql += 		"  SELECT pml_processdispose.fileid , MAX(pml_processdispose.transition_ ) as tran ";
			sql += 		"  FROM pml_processdispose ";
			sql += 		" WHERE pml_processdispose.fileid IN (";
			sql += 			 " SELECT DISTINCT pml_file.fileid ";
			sql +=			 " FROM pml_file , pml_filetype ";
			sql +=			 " WHERE pml_filetype.filetypeid IN (";
			
			for(PmlFileType fileType : fileTypeList) {
				sql += "'" + fileType.getFileTypeId() + "',";
			}
			sql +=			 " '0')";
			sql += 			 " AND pml_filetype.filetypeid = pml_file.filetypeid ";
			sql +=		 " ) ";
			sql += 		"  GROUP BY pml_processdispose.fileid ";
			sql += ") AS pml_pro, pml_file, pml_processdispose, pml_stateprocess ";
			sql += " WHERE  pml_pro.fileid = pml_processdispose.fileid ";
			sql += " AND pml_pro.tran = pml_processdispose.transition_  ";
			sql += " AND ( pml_pro.fileid = pml_file.fileid ) ";
			sql += " AND  pml_stateprocess.stateprocessid = pml_processdispose.stateprocessidbefore	 ";
			sql += " AND pml_stateprocess.stateprocesscode = 'chobosung' ";
			sql += " AND ( pml_processdispose.senddate IS NOT NULL )  ";
			sql += " AND ( '" + fromDate + "' <= pml_processdispose.senddate AND pml_processdispose.senddate <= '" + toDate + "')";
			
			if (typeList.size() > 0) { 
				if ("mahoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.numberreceipt LIKE '%" + valueTypeList.get(0)  +"%') ";
					
				} else if ("tenhoso".equals(typeList.get(0))) {
					sql = sql.replace( ") AS pml_pro, pml_file , pml_processdispose, pml_stateprocess ", ") AS pml_pro, pml_file , pml_processdispose, pml_stateprocess, pml_file_pccc");
					sql += "AND (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(0) + "%') ";
					
				} else if ("loaihoso".equals(typeList.get(0))) {
					sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					
				} else if ("ngaygui".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
					//TODO
				} else if ("ngaynhan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhethan".equals(typeList.get(0))) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[0]));
					String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(0).split("_")[1]));
					//TODO
				} else if ("ngayhentrakhach".equals(typeList.get(0))) {
					SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
					if (!"".equals(valueTypeList.get(0))) {
						String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[0]));
						String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(0).split("_")[1]));
						sql += "AND (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
					}
				}
				
			}
			if (typeList.size() > 1) {
				for (int i = 1; i < typeList.size(); i++) {	
					String sqlHelp = " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ";
					if ("mahoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.numberreceipt LIKE '%" + valueTypeList.get(i)  +"%') ";
						
					} else if ("tenhoso".equals(typeList.get(i))) {						
						sqlHelp = sqlHelp.replace( " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file ", " SELECT DISTINCT pml_file.*  FROM (" + sql + ") as pml_file , pml_file_pccc ");
						sqlHelp += " WHERE (pml_file.fileid = pml_file_pccc.fileid AND pml_file_pccc.filename like '%" + valueTypeList.get(i) + "%') ";
						
					} else if ("loaihoso".equals(typeList.get(i))) {
						sqlHelp += " WHERE (pml_file.filetypeid = '" + valueTypeList.get(i) + "') ";
						
					} else if ("ngaygui".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//sql += "AND (pml_file.filetypeid = '" + valueTypeList.get(0) + "') ";
						//TODO
					} else if ("ngaynhan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhethan".equals(typeList.get(i))) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String  beginDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[0]));
						String  endDate =	dateFormat.format(dateFormat.parse(valueTypeList.get(i).split("_")[1]));
						//TODO
					} else if ("ngayhentrakhach".equals(typeList.get(i))) {
						SimpleDateFormat dateFormatOne = new SimpleDateFormat("dd/MM/yyyy");
						SimpleDateFormat dateFormatTwo = new SimpleDateFormat("yyyy-MM-dd");
						if (!"".equals(valueTypeList.get(i))) {
							String  beginDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[0]));
							String  endDate =	dateFormatTwo.format(dateFormatOne.parse(valueTypeList.get(i).split("_")[1]));
							sqlHelp += " WHERE (('"+ beginDate +"' <= pml_file.expectedreturningdate ) AND (pml_file.expectedreturningdate <= '"+ endDate +  "')) ";
						}
					}
					sql = sqlHelp;
				}
				
			}
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_file", PmlOneDoorReceiveFileImpl.class);
			
			return (List<PmlOneDoorReceiveFile>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
}
