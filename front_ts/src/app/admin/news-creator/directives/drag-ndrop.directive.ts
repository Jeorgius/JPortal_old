import {
  Directive, EventEmitter, HostBinding, HostListener, Input, Output} from '@angular/core';


@Directive({
  selector: '[Drag-n-Drop]'
})
export class DragNDropDirective {
  @Input() private allowed_extensions :string[] = [];
  @Output() private fileDropped :EventEmitter<File[]> = new EventEmitter();
  @HostBinding('style.background') private background = "antiquewhite";

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

  @HostListener('dragleave', ['$event']) public dragLeave(event){
    this.preventDefaultRerouts(event);
    this.background="antiquewhite";
  }

  private preventDefaultRerouts(event){
  //prevent rerouts to picture view when dropping image to an ImageArea
    event.preventDefault();
    event.stopPropagation();
  }
}
