export interface HeaderConfig {
    showSearch: boolean;
    showCategory: boolean;
    showNotificationBell: boolean;
    sticky: boolean;
    transparent: boolean;
}

export interface HeaderState {
  isMenuOpen: boolean;
  searchQuery: string;
  cartItemCount: number;
}

export interface MenuItem {
    label: string;
    route: string;
    icon?: string;
    isActive?: boolean;
}