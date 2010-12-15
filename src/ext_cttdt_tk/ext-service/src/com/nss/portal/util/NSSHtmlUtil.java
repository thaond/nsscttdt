/**
 * 
 */

package com.nss.portal.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author canhminh
 */
public class NSSHtmlUtil {

	/**
	 * @param htmmlContent
	 * @param host
	 *            can be null
	 * @return list of image URLs
	 */
	public static List<String> getAllImageLinks(String htmmlContent, String host) {

		List<String> strings = new ArrayList<String>();
		int size = htmmlContent.length();
		for (int i = 0; i < size; i++) {
			char c = htmmlContent.charAt(i);
			if (c == '<') {
				StringBuilder sb = new StringBuilder();
				sb.append(c);
				sb.append(htmmlContent.charAt(++i));
				sb.append(htmmlContent.charAt(++i));
				sb.append(htmmlContent.charAt(++i));
				if (sb.toString().equals("<img")) {
					i = htmmlContent.indexOf("src=", i) + 4;
					sb = new StringBuilder();
					while (((c = htmmlContent.charAt(++i)) != '\"') &&
						((c = htmmlContent.charAt(i)) != '\'')) {
						sb.append(c);
					}
					String rs = sb.toString();
					if ((host != null) && (sb.indexOf("://") == -1)) {
						if (rs.charAt(0) != '/') {
							rs = host + '/' + sb.toString();
						}
						else {
							rs = host + sb.toString();
						}
					}

					strings.add(rs);
				}
			}
		}
		return strings;
	}
}
