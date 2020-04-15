package kz.itstep.sets;

import kz.itstep.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class CourceSet implements Iterable<Task> {
    private List<Task> cources;
    public CourceSet() {
        this.cources = new ArrayList<Task>();
    }
    public CourceSet(List<Task> cources){
        this.cources = cources;
    }
    @Override
    public Iterator<Task> iterator() {
        return cources.iterator();
    }
}
