package controllers.dao;


import entity.estimate.Estimate;

public interface EstimateDAO {

    int insert(Estimate obj);

    boolean delete(Estimate obj);

    boolean update(Estimate obj);

    Estimate get(int id);
}
