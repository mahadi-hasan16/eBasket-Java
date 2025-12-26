export interface FooterConfig {
    showNewsletter: boolean;
    showSitemap: boolean;
    showSocialLinks: boolean;
    showContactInfo: boolean;
}

export interface FooterColumn {
    title: string;
    links: FooterLink[];
}

export interface FooterLink {
    label: string;
    url: string;
    external?: boolean;
}

export interface SocialInfo {
    platform: string;
    url: string;
    icon?: string;
}

export interface ContactInfo {
    email: string;
    phone: string;
    address: string;
    businessHours: string;
}