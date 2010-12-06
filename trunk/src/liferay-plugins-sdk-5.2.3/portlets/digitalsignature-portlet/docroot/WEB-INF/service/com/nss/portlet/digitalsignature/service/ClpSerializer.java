/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.nss.portlet.digitalsignature.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import com.nss.portlet.digitalsignature.model.CertificateClp;
import com.nss.portlet.digitalsignature.model.SignatureClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ClpSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "digitalsignature-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(SignatureClp.class.getName())) {
			SignatureClp oldCplModel = (SignatureClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.nss.portlet.digitalsignature.model.impl.SignatureImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setSignatureId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getSignatureId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getGroupId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getCompanyId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserName",
							new Class[] { String.class });

					String value4 = oldCplModel.getUserName();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getCreateDate();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setArticlePrimKey",
							new Class[] { Long.TYPE });

					Long value6 = new Long(oldCplModel.getArticlePrimKey());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setArticleId",
							new Class[] { String.class });

					String value7 = oldCplModel.getArticleId();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setVersion",
							new Class[] { Double.TYPE });

					Double value8 = new Double(oldCplModel.getVersion());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setSignData",
							new Class[] { String.class });

					String value9 = oldCplModel.getSignData();

					method9.invoke(newModel, value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(CertificateClp.class.getName())) {
			CertificateClp oldCplModel = (CertificateClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.nss.portlet.digitalsignature.model.impl.CertificateImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getUserId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setX509Certificate",
							new Class[] { String.class });

					String value1 = oldCplModel.getX509Certificate();

					method1.invoke(newModel, value1);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel) {
			return translateInput((BaseModel)obj);
		}
		else if (obj instanceof List) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.nss.portlet.digitalsignature.model.impl.SignatureImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					SignatureClp newModel = new SignatureClp();

					Method method0 = oldModelClass.getMethod("getSignatureId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setSignatureId(value0.longValue());

					Method method1 = oldModelClass.getMethod("getGroupId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value1.longValue());

					Method method2 = oldModelClass.getMethod("getCompanyId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value2.longValue());

					Method method3 = oldModelClass.getMethod("getUserId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setUserId(value3.longValue());

					Method method4 = oldModelClass.getMethod("getUserName");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserName(value4);

					Method method5 = oldModelClass.getMethod("getCreateDate");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setCreateDate(value5);

					Method method6 = oldModelClass.getMethod(
							"getArticlePrimKey");

					Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

					newModel.setArticlePrimKey(value6.longValue());

					Method method7 = oldModelClass.getMethod("getArticleId");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setArticleId(value7);

					Method method8 = oldModelClass.getMethod("getVersion");

					Double value8 = (Double)method8.invoke(oldModel,
							(Object[])null);

					newModel.setVersion(value8.doubleValue());

					Method method9 = oldModelClass.getMethod("getSignData");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setSignData(value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.nss.portlet.digitalsignature.model.impl.CertificateImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CertificateClp newModel = new CertificateClp();

					Method method0 = oldModelClass.getMethod("getUserId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setUserId(value0.longValue());

					Method method1 = oldModelClass.getMethod(
							"getX509Certificate");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setX509Certificate(value1);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel) {
			return translateOutput((BaseModel)obj);
		}
		else if (obj instanceof List) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}