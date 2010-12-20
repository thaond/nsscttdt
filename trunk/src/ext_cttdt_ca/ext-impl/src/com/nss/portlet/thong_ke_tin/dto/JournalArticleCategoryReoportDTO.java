/**
 * 
 */

package com.nss.portlet.thong_ke_tin.dto;

/**
 * @author Tu
 */
public class JournalArticleCategoryReoportDTO {

	private long idVo;
	private String name;
	private String articleIds;
	private String articleIdApproveds;
	private String articleIdNotApproveds;
	private int countArticle, countArticleApproved, countArticleNotApproved,
					countArticleImage;

	public JournalArticleCategoryReoportDTO() {

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

	public long getIdVo() {

		return idVo;
	}

	public String getName() {

		return name;
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

	public void setIdVo(long idVo) {

		this.idVo = idVo;
	}

	public void setName(String name) {

		this.name = name;
	}

}
