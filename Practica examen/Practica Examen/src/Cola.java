public class Cola {
    private class Persona{
        Persona anterior;
        Persona proximo;
        String nombre;

        public Persona (){
            nombre = null;
            anterior = null;
            proximo = null;

        }
        public Persona(String name){
            nombre = name;
            anterior = null;
            proximo = null;
        }
    }

    Persona cabeza;
    public Cola(){
        cabeza = null;
    }
    
    public boolean vacia(){
        if (cabeza.proximo == null){
            return true;
        }else{
            return false;
        }
    }

    public void agregar(String name){
        nuevo = new Persona(name);
        Persona temp = cabeza;
        while (temp.proximo != null){
            temp = temp.proximo;
        }
        temp.proximo = nuevo;
        nuevo.anterior = temp;
    }

    public String sacar(){
        Persona sacado = cabeza;
        cabeza = sacado.proximo;
        cabeza.anterior = null;
        return sacado.nombre;
    }


}
