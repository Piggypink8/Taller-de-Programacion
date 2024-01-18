program Parcial1;

const

type
	banda = record
		nombre: String[15];
		fecha:integer;
		cantCanciones:integer;
		end;
	
	lista2 = ^nodo2;
	nodo2 = record
		elem:banda;
		sig:lista;
		end;
		
	recital = record
		recaudo:integer;
		bandas: lista2;
		end;
	
	lista = ^nodo;
	nodo = record
		elem: recital;
		sig:lista;
		end;
		
	arbol = ^hoja;
	hoja = record
		elem:lista;
		HI:arbol;
		HD:arbol;
		end;
		
	{	Inciso A	}
	
procedure leerRecital(var r:recital; var b:banda);
begin
	writeln('Ingrese un nombre');
	readln(b.nombre);
	if(r.nombre <> 'ZZZ')then begin
		writeln('Ingrese la fecha');
		readln(b.fecha);
		writeln('Ingrese un cantidad canciones');
		readln(b.cantCanciones);
		writeln('Ingrese un monto');
		readln(r.recaudo);
	end;
end;

procedure agregarAdelante(var L:lista2; b:banda);
var
	nue:lista;
begin
	new(nue);
	nue^.elem := b;
	nue^.sig := L;
	L:= nue;
end;

procedure agregarArbol(var a:arbol; r:recital; b:banda);
var
	nue:arbol;
begin
	if(a = nil)then begin
		new(nue);
		nue^.elem.recaudo:= recital.recaudo;
		nue^.elem.bandas := nil;
		agregarAdelante(nue^.elem.bandas,b);
		nue^.HI:= nil;
		nue^.HD := nil;
	end
	else
		if(a^.elem.recaudo > r.recaudo)then
			agregarArbol(a^.HI,r,b);
		else
			if(a^.elem.recaudo > r.recaudo)then
				agregarArbol(a^.HD,r,b);
			else
				agregarAdelante(a^.elem.bandas,b)
			
end;

procedure cargarArbol(var a:arbol);
var
	b:banda;
	r:recital;
begin
	leerRecital(r,b);
	while(b.nombre <> 'ZZZ')do begin
		agregarArbol(a,r,b);
		leerRecital(r,b)
	end;
end;

	{	Inciso B	}

procedure insertarOrdenado(var ln:lista: r:recital;);
var
	ant,act,nue:lista;
	
begin
	ant:= ln;
	act:= ln;
	new(nue);
	nue^.elem.recaudo := r.recaudo;
	nue^.elem.bandas:= r.bandas;
	while(act <> nil and (act^.elem.recaudo >= r.recaudo))do begin
		ant := act;
		act:= act^.sig ;
	end;
	
	if(ant = act)then
		ln:= nue;
	else
		ant^.sig := nue;
	 nue^.sig := act;
end;
procedure recorrerLista(L:lista; var ln:lista;);
var
begin
	ln:= nil;
	while((L <> nil)))do begin
		insertarOrdenado(ln,L^.elem);
		L:= L^.sig;
	end;
end;

procedure recitalesConMontoEntre(a:arbol;var L:lista;inf,sup:integer);
begin
	if(a<>nil)then begin
		if((a^.elem.recaudo <= sup))then
			if(a^.elem.recaudo >= inf)then begin
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

	{	Inciso C	}
	
function contarCanciones(L:lista2):integer;
var
	cant:integer;
begin
	cant:= 0;
	while(L<>nil and cant <= 12)do begin
		cant:= cant + L^.elem.cantCanciones:
		L := L^.sig;
	end;
	contarCanciones := cant;
end;

function cantRecitales(L:lista;cant:integer):integer;
begin
	if(L <> nil)then begin
		if(contarCanciones(L^.bandas) > 12)then
			cant:= cant + 1;
		cantRecitales:= cantRecitales(L^.sig,cant);
	end
	else
		cantRecitales:= cant;
end;

var
	teatro:arbol;
	l:lista;
	cant:integer
begin
	teatro:= nil;
	cargarArbol(teatro);
	
	l:= nil;
	recitalesConMontoEntre(teadro,l,200,500);
	
	cant:= 0;
	writeln('Cantidad de recitales con mas de 12 canciones: '+ cantRecitales(l,cant));
END.
