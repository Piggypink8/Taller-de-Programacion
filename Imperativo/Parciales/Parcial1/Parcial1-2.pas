program Parcial1-2; // Otra solucion al mismo parcial
type
	date = record
		dia:integer;
		mes:integer;
		anio:integer;
	end;
	
	recital = record
		banda:String[15];
		fecha:date;
		cantCanciones:integer;
		monto:real;
	end;
	
	arbol = ^hoja;
	hoja = record
		dato:recital;
		HI:arbol;
		HD:arbol;
	end;
	
	lista = ^nodo;
	nodo = record
		dato:recital;
		sig:lista;
	end;

procedure leerRecital(var r:recital);
begin
	writeln('Ingrese un nombre');
	readln(r.nombre);
	if(r.nombre <> 'ZZZ')then begin
		writeln('Ingrese la fecha');
		readln(r.fecha.date.dia);
    readln(r.fecha.date.mes);
    readln(r.fecha.date.anio);
		writeln('Ingrese un cantidad canciones');
		readln(r.cantCanciones);
		writeln('Ingrese un monto');
		readln(r.recaudo);
	end;
end;

procedure agregarArbol(var a:arbol; r:recital);
begin
	if(a = nil) then begin
		new(a);
		a^.dato:= r;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else 
    if(a^.dato.recaudo >= r.recaudo) then
		    cargarArbol(a^.HI,r)
	  else
		    cargarArbol(a^.HD,r);
end;

procedure cargarArbol(var a:arbol);
var
	r:recital;
begin
	leerRecital(r);
	while(r.banda <> 'ZZZ')do begin
		cargarArbol(a,r);
		leerRecital(r);
	end;
end;

{-------------------------------------------------}

procedure agregarRecital(var l:lista; r:recital);
var
	nue,ant,act:lista;
begin
	new(nue);
	nue^.dato:= r;
	act:= l;
	while(act <> nil) and (act^.dato.recaudo > r.recaudo) do begin
		ant:= act;
		act:= act^.sig;
	end;
	if(act = l) then
		l:= nue
	else
		ant^.sig:= nue;
	nue^.sig:= act;
end;

procedure recitalesConMontoEntre(a:arbol;var L:lista;inf,sup:integer);
begin
	if(a<>nil)then begin
		if((a^.dato.recaudo <= sup))then
			if(a^.dato.recaudo >= inf)then begin
				recorrerLista(a^.elem.bandas,L);
				recitalesConMontoEntre(a^.HI,L,inf,sup);
				recitalesConMontoEntre(a^.HD,L,inf,sup);
			end
			else
				recitalesConMontoEntre(a^.HI,L,inf,sup);
		else	
		recitalesConMontoEntre(a^.HD,L,inf,sup);
	end
end;

{ ---------------------------------------------------------- }

function contarCanciones(l:lista):integer;
begin
	if(l <> nil) then begin
		if(l^.dato.cantCanciones > 12) then
		  contarCanciones:= 1 + contarCanciones(l^.sig);
		else
			contarCanciones:= contarCanciones(l^.sig);
	end
	else
		contarCanciones:= 0;
end;

{ --------------------------------------------------------- }

procedure imprimirArbol(a:arbol);
begin
	if(a <> nil) then begin
		imprimirArbol(a^.HI);
		write('| recaudo: ', a^.dato.recaudo, ' |');
		imprimirArbol(a^.HD);
	end;
end;

procedure imprimirLista(l:lista);
begin
	while(l <> nil) do begin
		write('| recaudo: ', l^.dato.recaudo, ' |');
		l:= l^.sig;
	end;
end;

var
	a:arbol;
	l:lista;
	min,max:real;
begin
	a:= nil;
	writeln('ARBOL DE RECITALES');
	cargarInformacion(a);
	imprimirArbol(a);
	writeln('');
	writeln('');
	writeln('LISTA DE RECITALES');
	l:= nil;
	min:= 520;
	max:= 570;
	listaEntreMontos(a,l,min,max);
	imprimirLista(l);
end.
