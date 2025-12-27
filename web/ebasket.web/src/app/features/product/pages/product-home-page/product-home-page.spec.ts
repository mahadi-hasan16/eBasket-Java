import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductHomePage } from './product-home-page';

describe('ProductHomePage', () => {
  let component: ProductHomePage;
  let fixture: ComponentFixture<ProductHomePage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProductHomePage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductHomePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
