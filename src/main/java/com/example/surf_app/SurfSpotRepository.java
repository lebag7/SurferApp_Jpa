package com.example.surf_app;

import org.springframework.data.repository.CrudRepository;

import com.example.surf_app.SurfSpot;

public interface SurfSpotRepository extends CrudRepository<SurfSpot, Integer>  {
    
}
