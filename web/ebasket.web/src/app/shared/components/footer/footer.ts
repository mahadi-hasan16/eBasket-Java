import { Component, input, output, signal } from '@angular/core';
import { FooterConfig } from './footer.model';
import { ICONS } from '../../constants/icons';

@Component({
  selector: 'app-footer',
  imports: [],
  templateUrl: './footer.html',
  styleUrl: './footer.css'
})
export class Footer {
  ICONS = ICONS;

  config = input<FooterConfig>({
    showNewsletter: true,
    showSitemap: true,
    showContactInfo: true,
    showSocialLinks: true
  });

  newsletterSubscribe = output<string>();
  linkClick = output<string>();

  email = signal('');
  isSubscribed = signal(false);
  currentYear = signal(new Date().getFullYear());

  footerColumns = [
    {
      title: 'Shop',
      links: [
        { label: 'All Products', url: '/products' },
        { label: 'New Arrivals', url: '/products/new' },
        { label: 'Best Sellers', url: '/products/bestsellers' },
        { label: 'On Sale', url: '/products/sale' }
      ]
    },
    {
      title: 'Help',
      links: [
        { label: 'FAQ', url: '/help/faq' },
        { label: 'Shipping Info', url: '/help/shipping' },
        { label: 'Returns & Exchanges', url: '/help/returns' },
        { label: 'Contact Us', url: '/contact' }
      ]
    },
    {
      title: 'Company',
      links: [
        { label: 'About Us', url: '/about' },
        { label: 'Careers', url: '/careers' },
        { label: 'Privacy Policy', url: '/privacy' },
        { label: 'Terms of Service', url: '/terms' }
      ]
    }
  ];

  socialLinks = [
    { platform: 'facebook', url: '#', icon: '📘' },
    { platform: 'twitter', url: '#', icon: '🐦' },
    { platform: 'instagram', url: '#', icon: '📷' },
    { platform: 'linkedin', url: '#', icon: '💼' }
  ];

  contactInfo = {
    email: 'support@ebasket.com',
    phone: '+1 (555) 123-4567',
    address: '123 Commerce St, San Francisco, CA',
    businessHours: 'Mon-Fri 9AM-6PM PST'
  };


  onSubscribe(): void {
    const emailValue = this.email().trim();
    if (emailValue && this.validateEmail(emailValue)) {
      this.newsletterSubscribe.emit(emailValue);
      this.isSubscribed.set(true);
      this.email.set(''); 

      setTimeout(() => this.isSubscribed.set(false), 5000);
    }
  }

  onLinkClick(linkLabel: string): void {
    this.linkClick.emit(linkLabel);
  }

  private validateEmail(email: string): boolean {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
  }

}
