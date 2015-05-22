package com.dean.TheGymScraper.scrapers;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public abstract class AbstractScrape implements IScrape {

	/**
	 * Constructor should always take in the username and password, as this is
	 * always neccessary information to scrape a gym users info.
	 * 
	 * @param username
	 * @param password
	 */
	public AbstractScrape(String username, String password){};
	
	protected void setTrustAllCerts() throws Exception
	{
		TrustManager[] trustAllCerts = new TrustManager[]{
			new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}
				public void checkClientTrusted( java.security.cert.X509Certificate[] certs, String authType ) {	}
				public void checkServerTrusted( java.security.cert.X509Certificate[] certs, String authType ) {	}
			}
		};

		// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance( "SSL" );
			sc.init( null, trustAllCerts, new java.security.SecureRandom() );
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection.setDefaultHostnameVerifier( 
				new HostnameVerifier() {
					public boolean verify(String urlHostName, SSLSession session) {
						return true;
					}
				});
		}
		catch ( Exception e ) {
			//We can not recover from this exception.
			e.printStackTrace();
		}
	}
}
