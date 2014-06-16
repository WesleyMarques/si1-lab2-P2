package controllers;

import models.Meta;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	static Form<Meta> taskForm = Form.form(Meta.class);

    public static Result index() {
        return ok(index.render("Metas Pessoais"));
    }
    
    public static Result metas(){
    	return ok(index.render(Meta.all(), taskForm, "Metas Pessoais"));
    	
    }

}
