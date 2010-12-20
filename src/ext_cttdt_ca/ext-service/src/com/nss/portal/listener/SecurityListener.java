/**
 * 
 */

package com.nss.portal.listener;

import java.security.Security;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author canhminh
 */
public class SecurityListener implements ServletContextListener {

	private static Log _log = LogFactoryUtil.getLog(SecurityListener.class);

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

		Security.removeProvider("BC");
		_log.info("Remove BouncyCastle Provider");
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet
	 * .ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		Security.addProvider(new BouncyCastleProvider());
		_log.info("Register BouncyCastle Provider");
	}

}
