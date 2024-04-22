
/**
 * Write a description of class Laberinto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Generador
{
    public boolean puedoGenerar(String [] a,String x){
        String [] b = new String[x.length()];
        int aux = 0;
        b = llenar(b,x,aux);
        boolean res = false;
        int aux1 = 0;
        int aux2 = 0;
        res = puedoGenerar(a,b,res,aux1,aux2);
        return res;
    }
    
    private boolean puedoGenerar(String [] a,String [] b,boolean res,int aux1,int aux2){
        if(aux1 < a.length){
            if(a[aux1].length() < 2){
                if(a[aux1].equals(b[aux2])){
                    if(b[aux2].equals(b[b.length-1])){
                        res = true;
                    }else{
                        res = puedoGenerar(a,b,res,aux1+1,aux2+1);
                    }
                }else{
                    res = puedoGenerar(a,b,res,aux1+1,aux2);
                }
            }else{
                if(aux2 == b.length-1){
                    res = false;
                }else{
                    String [] c = new String[a[aux1].length()];
                    c = llenar(c,a[aux1],0);
                    int aux = 0;
                    boolean bandera = nue(c,b,aux,aux2);
                    if(bandera == true){
                        aux2 = aux2 + c.length;
                    }
                    if(aux2 == b.length){
                        res = true;
                    }else{
                        res = puedoGenerar(a,b,res,aux1+1,aux2);
                    }  
                } 
            } 
        }
        return res;
    }
    
    private boolean nue(String [] c, String [] b, int aux1, int aux2){
        boolean res = false;
        if(aux1 < c.length){
            if(c[aux1].equals(b[aux2])){
                if(c[aux1].equals(c[c.length-1])){
                    res = true;
                }else{
                    res = nue(c,b,aux1+1,aux2+1);
                }
            }else{
                res = false;
            }
        }
        return res;
    }
    
    private String[] llenar(String [] b, String x, int aux){
        if(aux < b.length){
            b[aux] = Character.toString(x.charAt(aux));
            llenar(b,x,aux+1);
        }
        return b;
    }
    
    
}
