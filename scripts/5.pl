#!/usr/bin/perl -w
open(PLIK, "dane.txt") || die "blad z otwarciem pliku";
while ($scalar = <PLIK>) {
     if ( $scalar  =~ /<font[^>]*>(.*?)<\/font>(.*?)<font[^>]*>(.*?)<\/font>(.*?)<font[^>]*>(.*?)<\/font>(.*?)<font[^>]*>(.*?)<\/font>(.*?)<font[^>]*>(.*?)<\/font>(.*?)<font[^>]*>(.*?)<\/font>/){
	$wykladowca = $11;
	if (!( $wykladowca =~ /^(.*?)a$/ )) { 
		if(exists($osoba{$wykladowca})){
		$ile = $osoba{$wykladowca};
		$ile++;
		$osoba{$wykladowca} = $ile;
		}
		else { 
			$osoba{$wykladowca} = 1;
		}
	}
}
}
@klucze = sort {$osoba{$a} <= $osoba{$b}} keys %osoba;
foreach $zmienna (@klucze) { 
print $zmienna .'-'. $osoba{$zmienna}."\n";
}
