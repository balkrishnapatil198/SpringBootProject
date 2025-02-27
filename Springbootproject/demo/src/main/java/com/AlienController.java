package com.telusko.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.telusko.demo.AlienRepo;
import com.telusko.demo.model.Alien;

@RestController
public class AlienController
{
    @Autowired
    AlienRepo repo; 

    @RequestMapping("/")
    public String home()
    {
        return "home.jsp";
    }
     @DeletMapping("/alien/{aid}")
    public String deleteAlien(@PathVariable int aid)
    {
        Alien a = repo.getOne(aid);
        repo.delete(a);
        return "deleted";
    }
    @PutMapping("/alien",consumes= {"application/json"})
    public Alien saveOrupdateAlien(@RequestBody Alien alien)
    {
        repo.save(alien);
        return alien;
    }

    @GetMapping(path="/aliens")
    public List<Alien> getAliens()
    {
        
        return repo.findAll();

    }

    @PutMapping(path="/alien")
    
    @RequestMapping("/alien/{aid}")
    public Optional<Alien> getAlien(@PathVariable("aid") int aid)
    {


        return repo.findById(aid);
    }
}