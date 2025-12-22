export interface User {
    id: number;
    firstName: string;
    lastName: string;
    avatarUrl: string;
    email: string;
    contact: string;
    isActive: boolean;
    role: UserRole;
}

export interface UserProfile {
    id: number;
    firstName: string;
    lastName: string;
    avaterUrl: string;
    role: UserRole;
}

export enum UserRole {
    CUSTOMER = 'CUSTOMER',
    ADMIN = 'ADMIN',
    MANAGER = 'MANAGER'
}