import { Component } from '@angular/core';
import { RouterOutlet } from "@angular/router";
import { Header } from "../../shared/components/header/header";
import { Footer } from "../../shared/components/footer/footer";

@Component({
  selector: 'app-public-layout',
  imports: [RouterOutlet, Header, Footer],
  templateUrl: './public-layout.html',
  styleUrl: './public-layout.css'
})
export class PublicLayout {
  headerConfig = {
    showSearch: true,
    showCategory: true,
    sticky: true,
    transparent: true
  };

  footerConfig = {
    showNewsletter: true,
    showSitemap: true,
    showSocialLinks: true,
    showContactInfo: true

  };
}
