/**
 * 
 */

package com.nss.portlet.thong_ke_tin.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.nss.portlet.thong_ke_tin.dto.JournalArticleCategoryReoportDTO;
import com.nss.portlet.thong_ke_tin.dto.JournalArticleUserReportDTO;

class AllArticleComparator implements Comparator<JournalArticleUserReportDTO> {

	String orderByType;

	public AllArticleComparator(String orderByType) {

		this.orderByType = orderByType;
	}

	public int compare(
		JournalArticleUserReportDTO o1, JournalArticleUserReportDTO o2) {

		if (orderByType.equals("asc")) {
			return o1.getCountArticle() - o2.getCountArticle();
		}
		else {
			return o2.getCountArticle() - o1.getCountArticle();
		}
	}
}

class ArticleApproved implements Comparator<JournalArticleUserReportDTO> {

	String orderByType;

	public ArticleApproved(String orderByType) {

		this.orderByType = orderByType;
	}

	public int compare(
		JournalArticleUserReportDTO o1, JournalArticleUserReportDTO o2) {

		if (orderByType.equals("asc")) {
			return o1.getCountArticleApproved() - o2.getCountArticleApproved();
		}
		else {
			return o2.getCountArticleApproved() - o1.getCountArticleApproved();
		}
	}
}

class ArticleCountImage implements Comparator<JournalArticleUserReportDTO> {

	String orderByType;

	public ArticleCountImage(String orderByType) {

		this.orderByType = orderByType;
	}

	public int compare(
		JournalArticleUserReportDTO o1, JournalArticleUserReportDTO o2) {

		if (orderByType.equals("asc")) {
			return o1.getCountArticleImage() - o2.getCountArticleImage();
		}
		else {
			return o2.getCountArticleImage() - o1.getCountArticleImage();
		}
	}
}

class ArticleNotApproved implements Comparator<JournalArticleUserReportDTO> {

	String orderByType;

	public ArticleNotApproved(String orderByType) {

		this.orderByType = orderByType;
	}

	public int compare(
		JournalArticleUserReportDTO o1, JournalArticleUserReportDTO o2) {

		if (orderByType.equals("asc")) {
			return o1.getCountArticleNotApproved() -
				o2.getCountArticleNotApproved();
		}
		else {
			return o2.getCountArticleNotApproved() -
				o1.getCountArticleNotApproved();
		}
	}
}

class CategoryAllArticle
	implements Comparator<JournalArticleCategoryReoportDTO> {

	String orderByType;

	public CategoryAllArticle(String orderByType) {

		this.orderByType = orderByType;
	}

	public int compare(
		JournalArticleCategoryReoportDTO o1, JournalArticleCategoryReoportDTO o2) {

		if (orderByType.equals("asc")) {
			return o1.getCountArticle() - o2.getCountArticle();
		}
		else {
			return o2.getCountArticle() - o1.getCountArticle();
		}
	}

}

class CategoryArticleApproved
	implements Comparator<JournalArticleCategoryReoportDTO> {

	String orderByType;

	public CategoryArticleApproved(String orderByType) {

		this.orderByType = orderByType;
	}

	public int compare(
		JournalArticleCategoryReoportDTO o1, JournalArticleCategoryReoportDTO o2) {

		if (orderByType.equals("asc")) {
			return o1.getCountArticleApproved() - o2.getCountArticleApproved();
		}
		else {
			return o2.getCountArticleApproved() - o1.getCountArticleApproved();
		}
	}
}

class CategoryArticleCountImage
	implements Comparator<JournalArticleCategoryReoportDTO> {

	String orderByType;

	public CategoryArticleCountImage(String orderByType) {

		this.orderByType = orderByType;
	}

	public int compare(
		JournalArticleCategoryReoportDTO o1, JournalArticleCategoryReoportDTO o2) {

		if (orderByType.equals("asc")) {
			return o1.getCountArticleImage() - o2.getCountArticleImage();
		}
		else {
			return o2.getCountArticleImage() - o1.getCountArticleImage();
		}
	}
}

class CategoryArticleNotApproved
	implements Comparator<JournalArticleCategoryReoportDTO> {

	String orderByType;

	public CategoryArticleNotApproved(String orderByType) {

		this.orderByType = orderByType;
	}

	public int compare(
		JournalArticleCategoryReoportDTO o1, JournalArticleCategoryReoportDTO o2) {

		if (orderByType.equals("asc")) {
			return o1.getCountArticleNotApproved() -
				o2.getCountArticleNotApproved();
		}
		else {
			return o2.getCountArticleNotApproved() -
				o1.getCountArticleNotApproved();
		}
	}
}

class CategoryComparator
	implements Comparator<JournalArticleCategoryReoportDTO> {

	String orderByType;

	public CategoryComparator(String orderByType) {

		this.orderByType = orderByType;
	}

	public int compare(
		JournalArticleCategoryReoportDTO o1, JournalArticleCategoryReoportDTO o2) {

		if (orderByType.equals("asc")) {
			return o1.getName().compareTo(o2.getName());
		}
		else {
			return o2.getName().compareTo(o1.getName());
		}
	}

}

/**
 * @author Tu
 */
public class SortUtil {

	public static List<JournalArticleCategoryReoportDTO> sortListCategoryReportDTO(
		String orderByCol, String orderByType,
		List<JournalArticleCategoryReoportDTO> list) {

		List<JournalArticleCategoryReoportDTO> result =
			new ArrayList<JournalArticleCategoryReoportDTO>();
		result.addAll(list);
		if (orderByCol.equals("nss-tk-loai-tin")) {
			Collections.sort(result, new CategoryComparator(orderByType));
		}
		else if (orderByCol.equals("nss-tk-bai-viet")) {
			Collections.sort(result, new CategoryAllArticle(orderByType));
		}
		else if (orderByCol.equals("nss-tk-bai-da-duyet")) {
			Collections.sort(result, new CategoryArticleApproved(orderByType));
		}
		else if (orderByCol.equals("nss-tk-bai-chua-duyet")) {
			Collections.sort(
				result, new CategoryArticleNotApproved(orderByType));
		}
		else if (orderByCol.equals("nss-tk-so-anh")) {
			Collections.sort(result, new CategoryArticleCountImage(orderByType));
		}
		return result;
	}

	public static List<JournalArticleUserReportDTO> sortListUserReportDTO(
		String orderByCol, String orderByType,
		List<JournalArticleUserReportDTO> list) {

		List<JournalArticleUserReportDTO> result =
			new ArrayList<JournalArticleUserReportDTO>();
		result.addAll(list);
		if (orderByCol.equals("nss-tk-user")) {
			Collections.sort(result, new UserComparator(orderByType));
		}
		else if (orderByCol.equals("nss-tk-bai-viet")) {
			Collections.sort(result, new AllArticleComparator(orderByType));
		}
		else if (orderByCol.equals("nss-tk-bai-da-duyet")) {
			Collections.sort(result, new ArticleApproved(orderByType));
		}
		else if (orderByCol.equals("nss-tk-bai-chua-duyet")) {
			Collections.sort(result, new ArticleNotApproved(orderByType));
		}
		else if (orderByCol.equals("nss-tk-so-anh")) {
			Collections.sort(result, new ArticleCountImage(orderByType));
		}
		return result;
	}

}

class UserComparator implements Comparator<JournalArticleUserReportDTO> {

	String orderByType;

	public UserComparator(String orderByType) {

		this.orderByType = orderByType;
	}

	public int compare(
		JournalArticleUserReportDTO o1, JournalArticleUserReportDTO o2) {

		if (orderByType.equals("asc")) {
			return o1.getUserName().compareTo(o2.getUserName());
		}
		else {
			return o2.getUserName().compareTo(o1.getUserName());
		}
	}

}
