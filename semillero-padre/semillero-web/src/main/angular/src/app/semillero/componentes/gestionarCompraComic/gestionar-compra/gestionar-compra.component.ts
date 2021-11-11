import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarComicService } from 'src/app/semillero/servicios/gestionar-comic.service';
import { ComicDTO } from 'src/app/semillero/dto/comic-dto';

@Component({
  selector: 'gestionar-compra',
  templateUrl: './gestionar-compra.component.html',
})
export class GestionarCompraComponent implements OnInit {

  public nombre: string;
  public comicDTO: ComicDTO;
  public mostrarItem: boolean;
  public mensajeEjecucion: string;

  constructor(private fb: FormBuilder, private router: Router, private gestionComicsService: GestionarComicService) {

  }

  ngOnInit() {
    this.comprarComic();
  }

  public comprarComic(): void {
    this.gestionComicsService.comprarComic(this.comicDTO).subscribe(data => {
      if (data.exitoso) {
        this.mostrarItem = true;
        this.mensajeEjecucion = data.mensajeEjecucion;
        console.log(data.mensajeEjecucion);
      } else {
        this.mostrarItem = true;
        this.mensajeEjecucion = data.mensajeEjecucion;
      }
    }, error => {
      console.log(error);
    });
  }


  public irAComponenteBienvida(comic: ComicDTO): void {
    this.cerrar();
    this.router.navigate(['bienvenida', comic]);
  }

  public cerrar(): void {
    this.mostrarItem = false;
  }

}
