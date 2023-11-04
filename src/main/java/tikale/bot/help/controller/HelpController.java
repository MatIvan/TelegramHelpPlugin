package tikale.bot.help.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tikale.bot.help.entity.dto.ClientSavedDto;
import tikale.bot.help.util.FileUtil;

@RestController
public class HelpController {

    @Autowired
    private FileUtil fileUtil;

    @PostMapping("/save")
    public void save(@RequestBody ClientSavedDto body) {
        fileUtil.save(body.getData());
    }

    @GetMapping("/load")
    public String load() {
        return fileUtil.load();
    }

}
