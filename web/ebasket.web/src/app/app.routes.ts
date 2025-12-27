import { Routes } from '@angular/router';
import { Shop } from './features/shop/shop';
import { NotFound } from './shared/components/errors/not-found/not-found';
import { ServerError } from './shared/components/errors/server-error/server-error';
import { PublicLayout } from './layouts/public-layout/public-layout';

export const routes: Routes = [
    { path: '', component: PublicLayout },
    { path: 'shop', component: Shop },
    { path: 'not-found', component: NotFound },
    { path: 'server-error', component: ServerError },
    { path: '**', redirectTo: 'not-found', pathMatch: 'full' }
];
