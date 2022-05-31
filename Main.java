public class Main {
    private static final int numThreads = 32;
    private static final int memSize = 10;
	public static void main(String[] args) throws InterruptedException {              	                
     long tempoInicial=System.currentTimeMillis();
    
    double[] soma = new double[40];
    double somaf=0;
    
    int[] memoria = new int[memSize];
        for (int i=0; i<memSize; i++) {
            memoria[i] = i;
        }
    
    Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            
          int inicio = (1000000/numThreads)*i;
          int fim = (1000000/numThreads)*(i+1);
            threads[i] = new Sleeper(i, soma,  numThreads, inicio, fim);
            
            threads[i].start();  
        }
      esperaThreads(threads); 
    
     
   
	for(int i2=0;i2<numThreads;i2++){ 
    somaf=soma[i2]+somaf;
   
    }
    System.out.println((somaf)*4);
    long tempoFinal = System.currentTimeMillis();
    System.out.println(tempoFinal-tempoInicial);
    
	}
  public static void esperaThreads(Thread[] threads) throws InterruptedException {
        for (Thread t : threads) {
            t.join();
        }
    }
  public static class Sleeper extends Thread {
        int tid, numThreads, i, ia, inicio, fim;
        int[] memoria;
    double[] soma = new double[20];
    double pi = 0;
    
    
        public Sleeper(int i,double[] soma, int numThreads,int inicio,int fim) {
          this.soma=soma;
          this.i = i;
          this.numThreads = numThreads;
          this.inicio = inicio;
          this.fim = fim;
          
            
        }
    @Override
        public void run() {
          
          tid=1000000/numThreads;
            for( ia =inicio;ia<fim;ia++){
              pi = ((Math.pow(-1, ia))/((2*ia)+1));
        
          soma[i]=pi+soma[i];
          
           
        }
    
}
    
    
  }
}
