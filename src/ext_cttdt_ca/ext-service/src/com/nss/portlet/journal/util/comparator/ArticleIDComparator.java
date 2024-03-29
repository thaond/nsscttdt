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

package com.nss.portlet.journal.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.journal.model.JournalArticle;

/**
 * <a href="ArticleIDComparator.java.html"><b><i>View Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 */
public class ArticleIDComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "journalarticle.articleId ASC";

	public static String ORDER_BY_DESC = "journalarticle.articleId DESC";

	private boolean _asc;

	public ArticleIDComparator() {

		this(false);
	}

	public ArticleIDComparator(boolean asc) {

		_asc = asc;
	}

	public int compare(Object obj1, Object obj2) {

		JournalArticle article1 = (JournalArticle) obj1;
		JournalArticle article2 = (JournalArticle) obj2;

		int value =
			article1.getArticleId().toLowerCase().compareTo(
				article2.getArticleId().toLowerCase());

		if (_asc) {
			return value;
		}
		else {
			return -value;
		}
	}

	public String getOrderBy() {

		if (_asc) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

}
