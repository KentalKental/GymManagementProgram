package main;

public interface Factory<T> {

	T create(int x, CrudService<Package> service);

}
