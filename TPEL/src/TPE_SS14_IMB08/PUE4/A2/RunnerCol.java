package TPE_SS14_IMB08.PUE4.A2;



public class RunnerCol implements Runnable{

    @Override
    public void run(){
        while(Counter.getWert() < 1000000){
            Long startwert = Counter.getWert();
            Collatz col = new Collatz(startwert);
            for (Long inti : col){
                //und wenn er nicht gestorben ist, dann lauft er noch heute
            }
            Counter.setLaengsteCollatz(col);
        }
    }
  
    
    

}
