/**
 * 
 */

package com.nss.portlet.thong_ke_tin.dto;

/**
 * @author Tu
 */
public class JournalArticleUserReportDTO {

	private String userName = "unkown";
	private long userId = 0;
	private String articleIds;
	private String articleIdApproveds;
	private String articleIdNotApproveds;
	private int countArticle, countArticleApproved, countArticleNotApproved,
					countArticleImage;

	public JournalArticleUserReportDTO() {

		countArticle =
			countArticleApproved =
				countArticleImage = countArticleNotApproved = 0;
	}

	public String getArticleIdApproveds() {

		return articleIdApproveds;
	}

	public String getArticleIdNotApproveds() {

		return articleIdNotApproveds;
	}

	public String getArticleIds() {

		return articleIds;
	}

	public int getCountArticle() {

		return countArticle;
	}

	public int getCountArticleApproved() {

		return countArticleApproved;
	}

	public int getCountArticleImage() {

		return countArticleImage;
	}

	public int getCountArticleNotApproved() {

		return countArticleNotApproved;
	}

	public long getUserId() {

		return userId;
	}

	public String getUserName() {

		return userName;
	}

	public void setArticleIdApproveds(String articleIdApproveds) {

		this.articleIdApproveds = articleIdApproveds;
	}

	public void setArticleIdNotApproveds(String articleIdNotApproveds) {

		this.articleIdNotApproveds = articleIdNotApproveds;
	}

	public void setArticleIds(String articleIds) {

		this.articleIds = articleIds;
	}

	public void setCountArticle(int countArticle) {

		this.countArticle = countArticle;
	}

	public void setCountArticleApproved(int countArticleApproved) {

		this.countArticleApproved = countArticleApproved;
	}

	public void setCountArticleImage(int countArticleImage) {

		this.countArticleImage = countArticleImage;
	}

	public void setCountArticleNotApproved(int countArticleNotApproved) {

		this.countArticleNotApproved = countArticleNotApproved;
	}

	public void setUserId(long userId) {

		this.userId = userId;
	}

	public void setUserName(String userName) {

		this.userName = userName;
	}
}
