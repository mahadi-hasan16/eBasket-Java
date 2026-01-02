import { ICONS } from "../../../../shared/constants/icons";

export interface Hero {
    title: string;
    subtitle: string;
    buttonText: string;
    buttonLink: string;
    buttonIcon: string,
    imageUrl: string;
}

export const CATEGORIES = [
    {
        name: 'Electronics',
        image: 'https://images.pexels.com/photos/2588757/pexels-photo-2588757.jpeg',
        link: '/category/electronics',
        productCount: 245
    },
    {
        name: 'Fashion',
        image: 'https://images.pexels.com/photos/322207/pexels-photo-322207.jpeg',
        link: '/category/fashion',
        productCount: 189
    },
    {
        name: 'Home & Garden',
        image: 'https://images.pexels.com/photos/9707349/pexels-photo-9707349.jpeg',
        link: '/category/home',
        productCount: 156
    }
];

export const TRUST_BADGES = [
    { icon: ICONS.FREE_SHIPPING, text: 'Free Shipping', subtext: 'On orders over $50' },
    { icon: ICONS.SECURE_PAYMENT, text: 'Secure Payment', subtext: '100% secure' },
    { icon: ICONS.SHIPPED, text: 'Fast Delivery', subtext: 'Same day shipping' },
    { icon: ICONS.SUPPORT, text: '24/7 Support', subtext: 'Dedicated support' }
];