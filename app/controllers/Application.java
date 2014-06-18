package controllers;

import models.Meta;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	static Form<Meta> taskForm = Form.form(Meta.class);

    public static Result index() {
    	initBD();
        return redirect(routes.Application.metas());
    }
    
    private static void initBD(){
    	Meta meta;
    	String[] nome = {"Wesley", "Ricardo", "Luis", "Fernando", "Pedro", "Thiago"};
    	int[] priority = {1, 1, 2, 2, 3, 3};
    	int[] semana = {1,2,1,2,1,2};
    	for (int i = 0; i < 6; i++) {
    		meta = new Meta();
    		meta.setNameMeta(nome[i]);
    		meta.setPriority(priority[i]);
    		meta.setWeek(semana[i]);    		
    		Meta.create(meta);    					
		}
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
