package Demo;



import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

import org.beetl.ext.jfinal.BeetlRenderFactory;
import java.io.File;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.WebAppResourceLoader;
import com.jfinal.plugin.c3p0.C3p0Plugin;


public class DemoConfig extends JFinalConfig {
		public void configConstant(Constants me) {
			me.setDevMode(true);
			me.setMainRenderFactory(new BeetlRenderFactory());
			GroupTemplate gt = BeetlRenderFactory.groupTemplate;
			WebAppResourceLoader loader = (WebAppResourceLoader) gt.getResourceLoader();
			loader.setRoot("D:\\test\\jfinal_debug\\WebRoot\\WEB-INF");
		}
		public void configRoute(Routes me) {
			me.add("/hello", HelloController.class);
		}
		public void configPlugin(Plugins me) {
			// 配置C3p0数据库连接池插件
			C3p0Plugin C3p0Plugin = new C3p0Plugin("jdbc:mysql://192.168.91.128/jfinal_demo?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull","root", "123456");
			me.add(C3p0Plugin);
			
			// 配置ActiveRecord插件
			ActiveRecordPlugin arp = new ActiveRecordPlugin(C3p0Plugin);
			me.add(arp);
			arp.addMapping("blog", "id", Mode.class);
		}
		public void configInterceptor(Interceptors me) {}
		public void configHandler(Handlers me) {}

}
