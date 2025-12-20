import { Component, inject } from '@angular/core';
import { LoaderService } from '../../services/loader-service';

@Component({
  selector: 'app-loader',
  imports: [],
  templateUrl: './loader.html',
  styleUrl: './loader.css'
})
export class Loader {
  loaderService = inject(LoaderService);

  isLoading = false;

  constructor() {
    this.loaderService.isLoading$.subscribe(
      (status) => {
        this.isLoading = status;
      }
    );
  }
}
