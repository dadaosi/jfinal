package Demo;

import com.jfinal.core.Controller;
import Demo.Mode;

public class HelloController extends Controller {
	public void index() {
		//renderText("Hello JFinal World.aaaaa");	
		redirect("/hello/hel");
		}
	public void hel() {
		//renderText("Hello JFinal World.aaaaa");
		setAttr("abc", "测试成功第4次"+Mode.mode.findFirst("select version() a /*from blog*/").getStr("a"));
		//Mode.mode.findFirst("", 123).getStr("a");
		Mode.mode.set("id", 99).set("title", "jfinal_debug").set("content", "jfinal_debug").save();

		render("/beetl/hello.html");
		
		}
	
	public void ext() {
		
		render("/beetl/extTest.html");
		
		}
}
