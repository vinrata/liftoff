package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.data.CarRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.UserRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by Team
 */
@Controller
public class HomeController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("users", userRepository.findAll());

        return "index";
    }

    @GetMapping("add")
    public String displayAddCarForm(Model model) {
        model.addAttribute(new Car());
        return "add";
    }

    @PostMapping("add")
    public String processAddCarForm(@ModelAttribute @Valid Car newCar,
                                       Errors errors) {

        if (errors.hasErrors()) {
            return "add";
        }

        carRepository.save(newCar);
        return "redirect:";
    }

    @GetMapping("view/{carId}")
    public String displayViewCar(Model model, @PathVariable int carId) {

        Optional optCar = carRepository.findById(carId);
        if (!optCar.isEmpty()) {
            Car car = (Car) optCar.get();
            model.addAttribute("car", car);
            return "view";
        } else {
            return "redirect:/";
        }
    }


}
