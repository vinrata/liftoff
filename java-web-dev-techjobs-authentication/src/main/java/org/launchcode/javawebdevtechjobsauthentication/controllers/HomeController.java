package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Fleet;
import org.launchcode.javawebdevtechjobsauthentication.models.User;
import org.launchcode.javawebdevtechjobsauthentication.models.data.CarRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.FleetRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.data.UserRepository;
import org.launchcode.javawebdevtechjobsauthentication.models.Car;
import org.launchcode.javawebdevtechjobsauthentication.models.dto.LoginDTO;
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
    private FleetRepository fleetRepository;

    @Autowired
    private UserRepository userRepository;



    @RequestMapping("")
    public String index(Model model, LoginDTO loginFormDTO) {

        User theUser = userRepository.findByUsername(loginFormDTO.getUsername());

        model.addAttribute("userr",theUser);
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("currentUser", loginFormDTO.getUsername());
        model.addAttribute("pfp", loginFormDTO.getPfp());

        return "index";
    }


    @GetMapping("add")
    public String displayAddCarForm(Model model) {
        model.addAttribute(new Car());
        return "add";
    }

    @GetMapping("add-fleet")
    public String displayAddFleetForm(Model model) {
        model.addAttribute(new Fleet());
        return "add-fleet";
    }


    @GetMapping("profile")
    public String displayProfile(Model model) {
        return "profile";
    }
    @GetMapping("view-fleets")
    public String displayViewFleets(Model model) {
        model.addAttribute("fleets", fleetRepository.findAll());

        return "view-fleets";
    }


    @GetMapping("view-managers")
    public String displayViewAllManagers(Model model) {
        model.addAttribute("users", userRepository.findAll());

        return "view-managers";
    }


    @GetMapping("car-pool")
    public String displayViewCarPool(Model model) {
        model.addAttribute("cars", carRepository.findAll());

        return "car-pool";
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
    @PostMapping("add-fleet")
    public String processAddFleetForm(@ModelAttribute @Valid Fleet newFleet,
                                    Errors errors) {

        if (errors.hasErrors()) {
            return "add-fleet";
        }

        fleetRepository.save(newFleet);
        return "view-fleets";
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
    @GetMapping("view-user/{userId}")
    public String displayViewUser(Model model, @PathVariable int userId) {

        Optional optUser = userRepository.findById(userId);
        if (!optUser.isEmpty()) {
            User user = (User) optUser.get();
            model.addAttribute("user", user);
            return "view-user";
        } else {
            return "redirect:/";
        }
    }

}
