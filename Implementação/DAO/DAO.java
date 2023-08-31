package DAO;
import java.util.ArrayList;


public class DAO<T> {

    public void cadastrar(T object, String path) {

    }

    public void editar(T object, T newObject, String path) {

    }

    public T excluir(T object, String path) {
        return object;
    }

    public T buscar(int id, String Path) {
        return null;
    }

    public ArrayList<T> buscarTodos (String path){
        ArrayList<T> list = new ArrayList<T>();
        return list;
    }

}
