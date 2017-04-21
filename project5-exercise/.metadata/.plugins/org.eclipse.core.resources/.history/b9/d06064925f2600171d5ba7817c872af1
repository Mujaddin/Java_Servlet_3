package BookManager;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
    
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
    
@ManagedBean
@SessionScoped
public class BookClass implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<BookObject> list;
    private BookObject item = new BookObject();
    private BookObject beforeEditItem = null;
    private boolean edit;
    
    @PostConstruct
    public void init() {
        list = new ArrayList<BookObject>();
    }
    
    public void add() {
        // DAO save the add
        item.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
        list.add(item);
        item = new BookObject();
        
    }
    
    public void resetAdd() {
        item = new BookObject();
    }
    
    public void edit(BookObject item) {
        beforeEditItem = item.clone();
        this.item = item;
        edit = true;
    }
    
    public void cancelEdit() {
        this.item.restore(beforeEditItem);
        this.item = new BookObject();
        edit = false;
    }
    
    public void saveEdit() {
        // DAO save the edit
        this.item = new BookObject();
        edit = false;
    }
    
    public void delete(BookObject item) throws IOException {
        // DAO save the delete
        list.remove(item);
    }
    
    public List<BookObject> getList() {
        return list;
    }
    
    public BookObject getItem() {
        return this.item;
    }
    
    public boolean isEdit() {
        return this.edit;
    }
    
}