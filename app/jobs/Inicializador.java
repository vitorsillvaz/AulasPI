package jobs;

import models.Pessoa;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job{
     
	@Override
    public void doJob() throws Exception {
    	if(Pessoa.count() == 0) {
    		Pessoa p1 = new Pessoa();
    		p1.nome = "João";
    		p1.email = "jo@gmail.com";
    		p1.save();
    	}
    }
}
