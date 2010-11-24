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

package com.liferay.portlet.messageboards.job;

import com.liferay.portal.kernel.job.IntervalJob;
import com.liferay.portal.kernel.job.JobSchedulerUtil;
import com.liferay.portal.kernel.job.Scheduler;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PropsValues;

/**
 * <a href="MBScheduler.java.html"><b><i>View Source</i></b></a>
 *
 * @author Michael Young
 *
 */
public class MBScheduler implements Scheduler {

	public void schedule() {
		if (PropsValues.MESSAGE_BOARDS_EXPIRE_BAN_INTERVAL <= 0) {
			if (_log.isDebugEnabled()) {
				_log.debug(
					"Auto expire of banned message board users is disabled");
			}

			_expireBanJob = null;
		}

		JobSchedulerUtil.schedule(_expireBanJob);
	}

	public void unschedule() {
		JobSchedulerUtil.unschedule(_expireBanJob);
	}

	private IntervalJob _expireBanJob = new ExpireBanJob();

	private static Log _log = LogFactoryUtil.getLog(Scheduler.class);

}