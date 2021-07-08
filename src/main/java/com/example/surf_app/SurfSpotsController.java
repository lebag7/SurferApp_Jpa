package com.example.surf_app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SurfSpotsController {
    private SurfSpotRepository surfSpotRepository;
    private AboutRepository aboutRepository;

    @Autowired
    public SurfSpotsController(SurfSpotRepository surfSpotRepository, AboutRepository aboutRepository) {
        super();
        this.surfSpotRepository = surfSpotRepository;
        this.aboutRepository = aboutRepository;
    };

    @GetMapping("/surf_spots")
    public String showSurfSpots(Model model) {

        List<SurfSpot> surfSpots = new ArrayList();
        surfSpotRepository.findAll().forEach(e -> surfSpots.add(e));
        model.addAttribute("surfSpots", surfSpots);
        return "surf_spots";
    }

    @GetMapping("/surf_spots/{surf_spotID}")
    public String surf_spot(@PathVariable("surf_spotID") Integer surf_spotID, Model model) {

        model.addAttribute("surf_spot", surfSpotRepository.findById(surf_spotID).get());
        return "surf_spot";
    }

    @PostMapping("/surf_spots/delete/{surf_spotID}")
    public String delete_surfSpot(@PathVariable("surf_spotID") Integer surf_spotID, Model model) {

        surfSpotRepository.deleteById(surf_spotID);
        return "redirect:/surf_spots";
    }

    @GetMapping("/surf_spots/edit/{surf_spotID}")
    public String surf_spot_edit(@PathVariable("surf_spotID") Integer surf_spotID, Model model) {

        model.addAttribute("surf_spot", surfSpotRepository.findById(surf_spotID));
        return "surf_spot_form_edit";
    }

    @PostMapping("/surf_spots/update")
    public String updateSurfSpot(@ModelAttribute SurfSpot surfSpot, Model model) {

        surfSpotRepository.save(surfSpot);
        return "redirect:/surf_spots";
    }

    @GetMapping("/about")
    public String about(Model model) {

        model.addAttribute("about", aboutRepository.findById(1).get());
        return "about";
    }

    @GetMapping("/surf_spots/new")
    public String showSurfSpotForm(Model model) {
        model.addAttribute("surf_spot", new SurfSpot());
        return "surf_spot_form";
    }

    @PostMapping("/surf_spots/submit")
    public String submitSurfSpot(@ModelAttribute SurfSpot surfSpot, Model model) {

        surfSpotRepository.save(surfSpot);
        return "redirect:/surf_spots";
    }

}
