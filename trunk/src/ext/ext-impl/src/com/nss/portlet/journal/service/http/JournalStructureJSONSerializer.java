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

package com.nss.portlet.journal.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.portlet.journal.model.JournalStructure;

import java.util.Date;
import java.util.List;

/**
 * <a href="JournalStructureJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.liferay.portlet.journal.service.http.JournalStructureServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.journal.service.http.JournalStructureServiceJSON
 *
 */
public class JournalStructureJSONSerializer {
	public static JSONObject toJSONObject(JournalStructure model) {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("uuid", model.getUuid());
		jsonObj.put("id", model.getId());
		jsonObj.put("groupId", model.getGroupId());
		jsonObj.put("companyId", model.getCompanyId());
		jsonObj.put("userId", model.getUserId());
		jsonObj.put("userName", model.getUserName());

		Date createDate = model.getCreateDate();

		String createDateJSON = StringPool.BLANK;

		if (createDate != null) {
			createDateJSON = String.valueOf(createDate.getTime());
		}

		jsonObj.put("createDate", createDateJSON);

		Date modifiedDate = model.getModifiedDate();

		String modifiedDateJSON = StringPool.BLANK;

		if (modifiedDate != null) {
			modifiedDateJSON = String.valueOf(modifiedDate.getTime());
		}

		jsonObj.put("modifiedDate", modifiedDateJSON);
		jsonObj.put("structureId", model.getStructureId());
		jsonObj.put("parentStructureId", model.getParentStructureId());
		jsonObj.put("name", model.getName());
		jsonObj.put("description", model.getDescription());
		jsonObj.put("xsd", model.getXsd());

		return jsonObj;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.journal.model.JournalStructure[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (JournalStructure model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.portlet.journal.model.JournalStructure[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (JournalStructure[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.portlet.journal.model.JournalStructure> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (JournalStructure model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}