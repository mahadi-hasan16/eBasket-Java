import { Component, input } from '@angular/core';
import { CATEGORIES, Hero, TRUST_BADGES } from './product-home-page.model';
import { RouterLink } from '@angular/router';
import { ICONS } from '../../../../shared/constants/icons';

@Component({
  selector: 'product-home-page',
  templateUrl: './product-home-page.html',
  styleUrl: './product-home-page.css',
  imports: [RouterLink],
})
export class ProductHomePage {
  hero = input<Hero>({
    title: 'Summer Sale',
    subtitle: 'Up to 50% off on selected items',
    buttonText: 'Shop Now',
    buttonIcon: ICONS.SHOP,
    buttonLink: '',
    imageUrl: 'https://picsum.photos/1200/600?random=1'
  });

  categories = CATEGORIES;
  trustBadges = TRUST_BADGES;

  featuredProducts = [];

  onShopNowClick(): void { console.log('On Shopped Clicked'); }

  onCategoryClick(categoryName: string): void { console.log('On Category Clicked'); }

  onTrustBadgeClick(badgeText: string): void { console.log('On Trust Badge Clicked'); }
}
