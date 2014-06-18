package controllers;

import models.DAO;
import models.Meta;
import play.*;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	static Form<Meta> taskForm = Form.form(Meta.class);
	private static DAO dao = new DAO();

	@Transactional
    public static Result index() {
		initBD();
        return redirect(routes.Application.metas());
    }
    
	@Transactional
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
    		dao.persist(meta);
    		dao.flush();
		}

    }
	@Transactional
    public static Result metas(){
    	return ok(views.html.index.render(dao.all(), taskForm));
    	
    }
	@Transactional
    public static Result newMeta() {
		  Form<Meta> filledForm = taskForm.bindFromRequest();
		  if(filledForm.hasErrors()) {
		    return badRequest(views.html.index.render(dao.all(), filledForm));
		  } else {
		    dao.persist(filledForm.get());
		    dao.flush();
		    return redirect(routes.Application.metas());  
		  }
	  }
	@Transactional
    public static Result deleteMeta(Long id) {
		  dao.delete(id);
		  dao.flush();
		  return redirect(routes.Application.metas());	
	  }
	@Transactional
    public static Result markMetaAsDone(Long id) {
		  dao.update(id);
		  dao.flush();
		  return redirect(routes.Application.metas());	
	  }


}
