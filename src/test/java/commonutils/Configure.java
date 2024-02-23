package commonutils;

public class Configure {
	public static void setEnvVars() {
		PropertiesReader props = new PropertiesReader();
		BaseUtil.props = props;
		
		try {
			Contstants.BROWSER_NAME = props.getValue("browser_name");
			Contstants.BROWSER_HEADLESS = Boolean.valueOf(props.getValue("browser_headless"));
			Contstants.EDGE_IE_MODE = Boolean.valueOf(props.getValue("edge_ie_mode"));
			
		} catch (Exception e) {
			System.err.println("Set the default values.");
			
			Contstants.BROWSER_NAME = "chrome";
			Contstants.BROWSER_HEADLESS = false;
			Contstants.EDGE_IE_MODE = false;
		}
	}
	
	public static void initBrowserSesion() {
		BaseUtil.setBrowser();
	}
}
