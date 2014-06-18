import static org.junit.Assert.*;
import models.Meta;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;


import play.db.jpa.JPA;
import play.db.jpa.JPAPlugin;
import play.test.FakeApplication;
import play.test.Helpers;
import scala.Option;


public class MetaTest {
	
	private Meta meta;
	public EntityManager em;

	@Before
	public void setUp() throws Exception {
		meta = new Meta();
		meta.setNameMeta("Estudar 1");
		meta.setPriority(1);
		meta.setWeek(1);
		FakeApplication app = Helpers.fakeApplication();
        Helpers.start(app);
        Option<JPAPlugin> jpaPlugin = app.getWrappedApplication().plugin(JPAPlugin.class);
        em = jpaPlugin.get().em("default");
        JPA.bindForCurrentThread(em);
        em.getTransaction().begin();
		
	}

	@After
	public void tearDown() throws Exception {
		meta = null;
	}

	@Test
	public void deveCriarMetatest() {
		meta.create(meta);
		assertTrue(meta.all().size()!=0);		
	}

}
