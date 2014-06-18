package controllers;

import models.Meta;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	static Form<Meta> taskForm = Form.form(Meta.class);

    public static Result index() {
        return redirect(routes.Application.metas());
    }
    
    public static Result metas(){
    	return ok(views.html.index.render(Meta.all(), taskForm));
    	
    }
    
    public static Result newMeta() {
		  Form<Meta> filledForm = taskForm.bindFromRequest();
		  if(filledForm.hasErrors()) {
		    return badRequest(views.html.index.render(Meta.all(), filledForm));
		  } else {
		    Meta.create(filledForm.get());
		    return redirect(routes.Application.metas());  
		  }
	  }
    
    public static Result deleteMeta(Long id) {
		  Meta.delete(id);
		  return redirect(routes.Application.metas());	
	  }
    
    public static Result markMetaAsDone(Long id) {
		  Meta.markAsDone(id);
		  return redirect(routes.Application.metas());	
	  }


}
