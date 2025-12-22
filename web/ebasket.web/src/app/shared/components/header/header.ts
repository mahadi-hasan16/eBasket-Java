import { Component, input, output, signal, computed, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MatAnchor, MatIconButton } from "@angular/material/button";
import { MatIcon } from "@angular/material/icon";
import { HeaderConfig, MenuItem } from './header.model';
import { UserProfile } from '../../models/user.model';
//import { CartService } from '../../../features/cart/services/cart.service';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule, RouterModule, MatAnchor, MatIconButton, MatIcon],
  templateUrl: 'header.html',
  styleUrl: 'header.css'
})
export class Header {
  config = input<HeaderConfig>(
    {
      showSearch: true,
      showCategory: true,
      sticky: true,
      transparent: false
    }
  );
  user = input<UserProfile | null>(null); 
  menu = input<MenuItem>();

  search = output<String>();
  logout = output<void>();
  menuToggle = output<void>();

  cartItemCount = signal(0);
  isMenuOpen = signal(false);
  searchQuery = signal('');


  constructor() {
    // Subscribe to cart updates reactively
    // this.cartService.cartCount$.subscribe(count => {
    //   this.cartItemCount.set(count);
    // });
  }

  onSearch(): void {
    const query = this.searchQuery().trim();
    if (query) {
      this.search.emit(query);
      this.searchQuery.set('');
    }
  }

  toggleMenu(): void {
    this.isMenuOpen.update(open => !open);
    this.menuToggle.emit();
  }

  onLogout(): void {
    this.logout.emit();
    this.isMenuOpen.set(false);
  }
}