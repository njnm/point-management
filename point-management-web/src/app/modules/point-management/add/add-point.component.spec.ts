import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { AddPointsComponent } from './add-point.component';


describe('AddPointsComponent', () => {
  let component: AddPointsComponent;
  let fixture: ComponentFixture<AddPointsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddPointsComponent ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPointsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
