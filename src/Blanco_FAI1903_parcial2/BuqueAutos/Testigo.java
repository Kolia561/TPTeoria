package Blanco_FAI1903_parcial2.BuqueAutos;

public class Testigo implements Runnable{
    
    private Buque buque;
    
	public Testigo(Buque buque) {
		this.buque = buque;
	}


	@Override
	public void run() {

        while (true) {

            buque.crusar();
            buque.bajarAutos();
            
            
        }

		
	}

}

    

