import {
  Directive, EventEmitter, HostBinding, HostListener, Input, Output} from '@angular/core';
import {ImageSaverService} from "../services/image_saver/image-saver.service";


@Directive({
  selector: '[Drag-n-Drop]'
})
export class DragNDropDirective {
  @Input() private allowed_extensions :string[] = [];
  @Input() private index :string = "";
  @Input() private blockType :string = "";

  @Output() private fileDropped :EventEmitter<File[]> = new EventEmitter();
  @HostBinding('style.background') private background = "antiquewhite";

  constructor(private ImageSaver :ImageSaverService) {}


  @HostListener('drop', ['$event'])
  public onDrop(event){
    this.preventDefaultRerouts(event);

    let files = event.dataTransfer.files;
    this.fileDropped.emit(files);
  }
  @HostListener('dragover', ['$event'])
  public dragOver(event){
    this.preventDefaultRerouts(event);
    this.background = "#777";
  }
  @HostListener('dragenter', ['$event'])
  public dragEnter(event){
    this.preventDefaultRerouts(event);
  }
  @HostListener('dragleave', ['$event'])
  public dragLeave(event){
    this.preventDefaultRerouts(event);
    this.background="antiquewhite";
  }

  private preventDefaultRerouts(event){
  //prevent rerouts to picture view when dropping image to an ImageArea
    event.preventDefault();
    event.stopPropagation();
  }

  async drag_n_drop(files :File[]){
    let message = await this.ImageSaver
      .saveImage(files[0])
      .toPromise();
    console.log("file drop: "+message)
  }
}
